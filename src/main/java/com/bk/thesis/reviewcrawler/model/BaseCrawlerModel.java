package com.bk.thesis.reviewcrawler.model;

import com.bk.thesis.configer.ZConfig;
import com.bk.thesis.reviewcrawler.handler.IReviewHandler;
import com.bk.thesis.data.thrift.TProduct;
import com.bk.thesis.data.thrift.TProductPage;
import com.bk.thesis.data.thrift.TProductResult;
import com.bk.thesis.data.thrift.TRawReview;
import com.bk.thesis.data.thrift.TRawReviewPage;
import com.bk.thesis.data.thrift.TRawReviewResult;
import com.bk.thesis.data.thrift.TReviewMeta;
import com.bk.thesis.db.ZMongo;
import com.bk.thesis.reviewcrawler.common.CrawlerConfig;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.log4j.Logger;

/**
 *
 * @author boeingtuan
 */
public abstract class BaseCrawlerModel {

    private static final Class ThisClass = BaseCrawlerModel.class;
    private static final Logger _Logger = Logger.getLogger(ThisClass);

    protected static final CloseableHttpClient httpClient;
    protected final CrawlerConfig _config;
    protected final ZMongo mongodb;

    static {
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(3, TimeUnit.MINUTES);
//        manager.setMaxTotal(20);
        httpClient = HttpClients.custom()
                .setConnectionManager(manager)
                .build();
    }

    public BaseCrawlerModel(CrawlerConfig _config) throws Exception {
        if (!_config.validate()) {
            throw new Exception("CrawlerConfig is not fully initialize, please check all attributes again");
        }
        this._config = _config;
        this.mongodb = ZMongo.getInstance(_config.getDbConf());
    }

    protected long getCurrentTime(String productId) {
        try {
            TProduct product = mongodb.get(productId, TProduct.class);
            if (product.getCurrentTime() == 0) {
                product.setCurrentTime(System.currentTimeMillis());
                mongodb.update(productId, product);
            }            
            return product.getCurrentTime();
        } catch (Exception ex) {
            _Logger.error(ex.getMessage(), ex);
            return System.currentTimeMillis();
        }
    }

    protected void resetCurrentTime(String productId) {
        try {
            TProduct product = mongodb.get(productId, TProduct.class);
            product.setCurrentTime(0);
            mongodb.update(productId, product);
        } catch (Exception ex) {
            _Logger.error(ex);
        }
    }

    public TProductResult crawlProduct(String seedlink) {
        long startTime = System.currentTimeMillis();
        int cnt = 0;
        int curPage = 0;
        TProductPage curProductPage = getProductPage(curPage);
        int errorCons = 0;
        while (errorCons < _config.getErrorConsThreshold() && curPage < _config.getMaxProductPage()) {
            if (!curProductPage.isError()) {
                errorCons = 0;
                if (curProductPage.isExist()) {
                    String pageData = curProductPage.getPageData();
                    List<TProduct> products = parseProductPage(pageData);

                    //store all product in db
                    for (TProduct product : products) {
                        if (!mongodb.exist(product.getProductId())) {
                            boolean check = mongodb.put(product.getProductId(), product);
                            if (check) {
                                cnt++;
                            }
                        }
                    }
                } else {
                    break;
                }
            } else {
                errorCons++;
            }
            curPage++;
            curProductPage = getProductPage(curPage);
        }
        long endTime = System.currentTimeMillis();
        TProductResult ret = new TProductResult(cnt, endTime - startTime);

        return ret;
    }

    private List<TProduct> getProducts(int from, int limit) {
        List<TProduct> products = mongodb.getSlice(from, limit, TProduct.class);
        return products;
    }

    public void crawlReview(IReviewHandler reviewHandler, int numberReviewPerPage) {
        int maxDoc = (int) mongodb.size();
        int from = 0;
        int limit = _config.getLimitProductBatchSize();
        ExecutorService executor = Executors.newFixedThreadPool(4);

        while (from < maxDoc) {
            List<TProduct> products = mongodb.getSlice(from, limit, TProduct.class);
            from += products.size();
            if (products.isEmpty()) {
                break;
            }

            for (TProduct product : products) {
                executor.execute(new WorkerProductThread(product, reviewHandler, numberReviewPerPage));
            }

            executor.shutdown();
            try {
                executor.awaitTermination(_config.getTimeout(), TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                _Logger.error(ex.getMessage(), ex);
            }

        }
    }

    protected abstract TProductPage getProductPage(int pageIndex);

    protected abstract List<TProduct> parseProductPage(String pageData);

    protected abstract TRawReviewPage getReviewPage(TProduct product, int pageIndex);

    protected abstract TRawReviewResult parseReviewPage(TProduct product, String pageData, boolean isCer, boolean isGetAll);

    public class WorkerProductThread implements Runnable {

        private final TProduct product;
        private final IReviewHandler handler;
        private final int numberReviewPerPage;

        public WorkerProductThread(TProduct product, IReviewHandler handler, int numberReviewPerPage) {
            this.product = product;
            this.handler = handler;
            this.numberReviewPerPage = numberReviewPerPage;
        }

        @Override
        public void run() {
            // everything in this should be thread safe
            resetCurrentTime(product.getProductId());
            //parse cer review 
            int pageIndex = 0;
            boolean isGetAll = product.getCerReviews().getLength() == 0;
            getReviews(pageIndex, true, isGetAll);

            //parse not cer review
            pageIndex = product.getCerReviews().getLength() / numberReviewPerPage;
            isGetAll = product.getNotcerReviews().getLength() == 0;
            getReviews(pageIndex, false, isGetAll);
        }

        private void getReviews(int pageIndex, boolean cond, boolean isGetAll) {
            TRawReviewPage reviewPage = getReviewPage(product, pageIndex);
            int errorCons = 0;
            while (errorCons < _config.getErrorConsThreshold()) {
                if (!reviewPage.isError()) {
                    errorCons = 0;
                    if (reviewPage.isExist()) {
                        TRawReviewResult reviews = parseReviewPage(product, reviewPage.getPageData(), cond, isGetAll);
                        TReviewMeta cerReviews = reviews.getCerReviews();
                        TReviewMeta notcerReviews = reviews.getNotcerReviews();

                        product.setCerReviews(cerReviews);
                        product.setNotcerReviews(notcerReviews);
                        mongodb.update(product.getProductId(), product);

                        //handler reviews
                        for (TRawReview review : reviews.getListRawReview()) {
                            handler.handlerReview(review);
                        }

                        if (!reviews.isCanCont()) {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    errorCons++;
                }
                pageIndex++;
                reviewPage = getReviewPage(product, pageIndex);
            }
        }
    }
}
