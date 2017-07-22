package com.bk.thesis.reviewcrawler.process;

import com.bk.thesis.data.thrift.TProductResult;
import com.bk.thesis.data.thrift.TRawReview;
import com.bk.thesis.reviewcrawler.common.CrawlerConfig;
import com.bk.thesis.reviewcrawler.handler.IReviewHandler;
import com.bk.thesis.reviewcrawler.model.BaseCrawlerModel;
import com.bk.thesis.reviewcrawler.model.TgddCateProductModel;
import com.bk.thesis.reviewcrawler.model.TgddReviewModel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.log4j.Logger;

/**
 *
 * @author boeingtuan
 */
public class WorkerProcess {

    private static final Class ThisClass = BaseCrawlerModel.class;
    private static final Logger _Logger = Logger.getLogger(ThisClass);
    public static final WorkerProcess Instance = new WorkerProcess();

    private static final AtomicInteger stat = new AtomicInteger();
    private static final Map<String, TRawReview> reviewSet = new HashMap();
    private int i = 0;

    public void run() throws Exception {
        CrawlerConfig config = new CrawlerConfig();
        config.setDbConf("TgddMongoDatabase");
        config.setLimitProductBatchSize(100);
        config.setMaxProductPage(2);
        config.setPrefixId("tgdd");
        config.setTimeout(10);

        TgddCateProductModel model = new TgddCateProductModel(config, 42);
        TProductResult crawlProduct = model.crawlProduct("https://www.thegioididong.com/dtdd");
        System.out.println("Crawl product complete: " + crawlProduct);
        
        for (i = 0; i < 5; i++) {
            stat.set(0);
            System.out.println("Turn " + (i+1));
            model.crawlReview(new IReviewHandler() {
                @Override
                public void handlerReview(TRawReview rawReview) {
                    //System.out.println(rawReview.getTitle());
                    if (!reviewSet.containsKey(rawReview.getReviewId())) {
                        if (i > 0) {
                            System.out.println("New item: " + rawReview);
                        }
                        reviewSet.put(rawReview.getReviewId(), rawReview);
                    } else {
                        System.out.println("Duplicate id: " + rawReview);
                        System.out.println(reviewSet.get(rawReview.getReviewId()));
                    }
                    int statInt = stat.incrementAndGet();
                    if (statInt % 100 == 0) {
                        System.out.println(statInt);
                    }
                }
            }, 3);
            System.out.println("Total reviews: " + stat);
        }
//        model.setParseProduct(TgddReviewModel.TGDD_PARSE_PRODUCT);
//        model.crawlReviewByLink("https://www.thegioididong.com/dtdd/samsung-galaxy-note-5", new IReviewHandler() {
//            @Override
//            public void handlerReview(TRawReview rawReview) {
//                System.out.println(stat.incrementAndGet());
//                System.out.println(rawReview);
//            }
//        }, 3);
    }

    public static void main(String[] args) throws Exception {
        WorkerProcess.Instance.run();
        System.exit(0);
    }
}
