package com.bk.thesis.reviewcrawler.model;

import com.bk.thesis.data.thrift.TProduct;
import com.bk.thesis.data.thrift.TProductPage;
import com.bk.thesis.data.thrift.TReviewMeta;
import com.bk.thesis.reviewcrawler.common.CrawlerConfig;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author boeingtuan
 */
public class TgddCateProductModel extends TgddReviewModel {

    private static final Class ThisClass = TgddCateProductModel.class;
    private static final Logger _Logger = Logger.getLogger(ThisClass);

    private static final String _endPointProductPage;
    private static final String _prefixLink;
    private static final Pattern _regex;
    private static final TReviewMeta _cerReviews;
    private static final TReviewMeta _notcerReviews;
    private static final int _nretry;
    private int cateId;

    static {
        _endPointProductPage = "https://www.thegioididong.com/aj/CategoryV4/Product";
        _prefixLink = "https://www.thegioididong.com/";
        _nretry = 3;
        _regex = Pattern.compile("(\\/[0-9]+)");
        _cerReviews = new TReviewMeta(0, "", 0);
        _notcerReviews = new TReviewMeta(0, "", 0);
    }

    public TgddCateProductModel(CrawlerConfig _config, int cateId) throws Exception {
        super(_config);
        this.cateId = cateId;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Override
    protected TProductPage getProductPage(int pageIndex) {
        TProductPage ret = new TProductPage(true, false);
        try {
            URI uri = new URIBuilder(_endPointProductPage)
                    .addParameter("Category", cateId + "")
                    .addParameter("PageSize", "30")
                    .addParameter("PageIndex", pageIndex + "")
                    .build();
            HttpPost postReq = new HttpPost(uri);
            postReq.setHeader("Content-Type", "application/x-www-form-urlencoded");
            postReq.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) "
                    + "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 "
                    + "Safari/537.36");

            for (int i = 0; i < _nretry; i++) {
                HttpResponse response = httpClient.execute(postReq);
                HttpEntity entity = response.getEntity();
                StatusLine status = response.getStatusLine();
                if (status.getStatusCode() == HttpStatus.SC_OK && entity != null) {
                    long len = entity.getContentLength();
                    String pageData = EntityUtils.toString(entity);
                    ret.setError(false);
                    ret.setExist(Jsoup.parse(pageData).select(".emptystate").isEmpty());
                    ret.setPageData(pageData);
                } else {
                    if (i == _nretry - 1) {
                        _Logger.error("HTTPClient fail: " + pageIndex + " " + status.getStatusCode());
                    }
                    Thread.sleep(500);
                }
                postReq.releaseConnection();
            }

        } catch (URISyntaxException | IOException | InterruptedException ex) {
            _Logger.error(ex.getMessage(), ex);
        }
        return ret;
    }

    @Override
    protected List<TProduct> parseProductPage(String pageData) {
        Document html = Jsoup.parse(pageData);
        Elements productsHtml = html.select("ul.cate  li");
        List<TProduct> ret = new ArrayList();

        for (Element productHtml : productsHtml) {
            try {
                String title = productHtml.select("h3").first().text();
                Element img = productHtml.select("img").first();
                String productId = getProductId(img);

                String url = _prefixLink + productHtml.attr("href");

                TProduct product = new TProduct(productId, url, title, _cerReviews, _notcerReviews, 0);
                ret.add(product);

                Elements versionsHtml = productHtml.select("div.version");
                if (versionsHtml.size() > 0) {
                    List<TProduct> versionProduct = parseVersionProduct(versionsHtml.first());
                    ret.addAll(versionProduct);
                }

            } catch (Exception ex) {
                _Logger.error(ex.getMessage(), ex);
            }
        }
        return ret;
    }

    private String getProductId(Element img) {
        String imgUrl = img.attr("src");
        Matcher m = _regex.matcher(imgUrl);
        // get second number -> product id of tgdd
        String ret;
        if (m.find()) {
            m.find();
            ret = m.group(1).substring(1);
        } else {
            imgUrl = img.attr("data-original");
            m = _regex.matcher(imgUrl);
            m.find();
            m.find();
            ret = m.group(1).substring(1);
        }

        return ret;
    }

    private List<TProduct> parseVersionProduct(Element html) {
        Elements urls = html.select("a");
        List<TProduct> ret = new ArrayList();
        for (Element url : urls) {
            String urlStr = _prefixLink + url.attr("href");
            try {                
                Document productHtml = Jsoup.parse(new URL(urlStr), 2000);
                Elements imgs = productHtml.select("aside.picture img");
                if (imgs.size() > 0) {
                    Element img = imgs.first();
                    String productId = getProductId(img);
                    String title = productHtml.select(".rowtop h1").text();
                    
                    TProduct product = new TProduct(productId, urlStr, title, _cerReviews, _notcerReviews, 0);
                    ret.add(product);
                }
            } catch (IOException ex) {
                _Logger.error(ex.getMessage() + " URL: " + urlStr, ex);
            }
        }

        return ret;
    }

}
