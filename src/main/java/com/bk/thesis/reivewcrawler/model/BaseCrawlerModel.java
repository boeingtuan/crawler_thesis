package com.bk.thesis.reivewcrawler.model;

import com.bk.thesis.conf.ConfigUtils;
import com.bk.thesis.reivewcrawler.common.CrawlerConfig;
import com.bk.thesis.reivewcrawler.common.Product;
import com.bk.thesis.reivewcrawler.common.ProductCrawlerResult;
import com.bk.thesis.reivewcrawler.common.ProductsPage;
import com.typesafe.config.Config;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author boeingtuan
 */
public abstract class BaseCrawlerModel {

    private static final Class ThisClass = BaseCrawlerModel.class;
    private static final Logger _Logger = Logger.getLogger(ThisClass);
    private static final Config _Conf = ConfigUtils.Instance.getConfig();

    private final CrawlerConfig _config;

    public BaseCrawlerModel(CrawlerConfig _config) {
        this._config = _config;
    }

    public ProductCrawlerResult crawlProduct() {
        long startTime = System.currentTimeMillis();
        int cnt = 0;
        int curPage = 1;
        ProductsPage curProductPage = getProductPage(curPage);
        while (curPage <= _config.getMaxProductPage() && curProductPage.isExist()) {
            String pageData = curProductPage.getPageData();
            List<Product> products = parseProductPage(pageData);
            cnt += products.size();
            //TODO: store all product in db
            
            curPage++;
            curProductPage = getProductPage(curPage);
        }
        long endTime = System.currentTimeMillis();
        ProductCrawlerResult ret = new ProductCrawlerResult(cnt, endTime - startTime);
        
        return ret;
    }

    protected abstract ProductsPage getProductPage(int pageIndex);

    protected abstract List<Product> parseProductPage(String pageData);

}
