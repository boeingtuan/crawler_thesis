package com.bk.thesis.reviewcrawler.process;

import com.bk.thesis.data.thrift.TProductResult;
import com.bk.thesis.data.thrift.TRawReview;
import com.bk.thesis.reviewcrawler.common.CrawlerConfig;
import com.bk.thesis.reviewcrawler.handler.IReviewHandler;
import com.bk.thesis.reviewcrawler.model.BaseCrawlerModel;
import com.bk.thesis.reviewcrawler.model.TgddCateProductModel;
import org.apache.log4j.Logger;

/**
 *
 * @author boeingtuan
 */
public class WorkerProcess {

    private static final Class ThisClass = BaseCrawlerModel.class;
    private static final Logger _Logger = Logger.getLogger(ThisClass);
    public static final WorkerProcess Instance = new WorkerProcess();
    
    private static int stat = 0;
    
    public void run() throws Exception {
        CrawlerConfig config = new CrawlerConfig();
        config.setDbConf("TgddMongoDatabase");
        config.setLimitProductBatchSize(100);
        config.setMaxProductPage(1);
        config.setPrefixId("tgdd");
        config.setTimeout(10);
        
        TgddCateProductModel model = new TgddCateProductModel(config, 42);
        TProductResult crawlProduct = model.crawlProduct("https://www.thegioididong.com/dtdd");
        System.out.println("Crawl product complete: " + crawlProduct);
        
        model.crawlReview(new IReviewHandler() {
            @Override
            public void handlerReview(TRawReview rawReview) {
                System.out.println(rawReview.getTitle());
                stat++;
            }
        }, 3);
        System.out.println("Total reviews: " + stat);
    }
    
    public static void main(String[] args) throws Exception {
        WorkerProcess.Instance.run();
        System.exit(0);
    }
}
