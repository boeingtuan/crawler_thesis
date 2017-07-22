package com.bk.thesis.reviewcrawler.model;

import com.bk.thesis.configer.ZConfig;
import com.bk.thesis.data.thrift.TProduct;
import com.bk.thesis.data.thrift.TRawReview;
import com.bk.thesis.data.thrift.TRawReviewPage;
import com.bk.thesis.data.thrift.TRawReviewResult;
import com.bk.thesis.data.thrift.TReviewMeta;
import com.bk.thesis.reviewcrawler.common.CrawlerConfig;
import com.bk.thesis.reviewcrawler.common.HttpCommon;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
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
public abstract class TgddReviewModel extends BaseCrawlerModel {

    private static final Class ThisClass = TgddReviewModel.class;
    private static final Logger _Logger = Logger.getLogger(ThisClass);

    public static final ParseProduct TGDD_PARSE_PRODUCT;
    private static final String _endPointRatingComment;
    private static final Map<String, Long> _timeUnit;
    private static final int _nretry;
    private static final String _proxyHost;
    private static final int _proxyPort;

    static {
        TGDD_PARSE_PRODUCT = new TgddParseProduct();
        _endPointRatingComment = "https://www.thegioididong.com/aj/ProductV4/RatingCommentList";
        _timeUnit = new HashMap();
        _timeUnit.put("phút", 60000L);
        _timeUnit.put("giờ", 3600000L);
        _timeUnit.put("ngày", 86400000L);
        _timeUnit.put("tuần", 604800000L);
        _timeUnit.put("tháng", 2629746000L);
        _nretry = 5;
        _proxyHost = ZConfig.Instance.getString(ThisClass, "config", "proxy_host", "123.30.129.168");
        _proxyPort = ZConfig.Instance.getInt(ThisClass, "config", "proxy_port", 3128);
    }

    public TgddReviewModel(CrawlerConfig _config) throws Exception {
        super(_config);
    }

    @Override
    protected TRawReviewPage getReviewPage(TProduct product, int pageIndex, boolean useProxy) {
        TRawReviewPage ret = new TRawReviewPage(true, false);
        try {
            URI uri = new URIBuilder(_endPointRatingComment)
                    .addParameter("productid", product.getProductId() + "")
                    .addParameter("page", ++pageIndex + "")
                    .build();
            HttpPost postReq = new HttpPost(uri);
            if (useProxy) {
                HttpHost proxy = new HttpHost(_proxyHost, _proxyPort, "http");
                RequestConfig config = RequestConfig.custom()
                        .setProxy(proxy)
                        .build();
                postReq.setConfig(config);
            }
            postReq.setHeader("Content-Type", "application/x-www-form-urlencoded");
            postReq.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) "
                    + "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 "
                    + "Safari/537.36");

            for (int i = 0; i < _nretry; i++) {
                HttpResponse response = httpClient.execute(postReq);
                HttpEntity entity = response.getEntity();
                StatusLine status = response.getStatusLine();
                if (status.getStatusCode() == HttpStatus.SC_OK && entity != null) {
                    String pageData = EntityUtils.toString(entity);
                    ret.setError(false);
                    ret.setExist(!pageData.isEmpty());
                    ret.setPageData(pageData);

                    break;
                } else {
                    if (i == _nretry - 1) {
                        _Logger.error("HTTPClient fail: " + product.getProductId() + " " + pageIndex + " " + status.getStatusCode());
                    }
                    Thread.sleep(1000);
                }
                postReq.releaseConnection();
            }

        } catch (URISyntaxException | IOException | InterruptedException ex) {
            _Logger.error(ex.getMessage(), ex);
        }
        return ret;

    }

    @Override
    protected int getExpectReview(String url) {
        try {
            String html = HttpCommon.getWebpage(url, 5);
            Document productHtml = Jsoup.parse(html);
            String ratingResult = productHtml.select("div.ratingresult a").first().text();
            return Integer.valueOf(ratingResult.split(" ")[0]);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    protected TRawReviewResult parseReviewPage(TProduct product, String pageData, boolean isCer, boolean isGetAll) {
        Document html = Jsoup.parse(pageData);
        Elements reviews = html.select("ul.ratingLst > li.par");
        List<TRawReview> rawReviews = new ArrayList();

        TReviewMeta cerReviews = product.getCerReviews();
        TReviewMeta notcerReviews = product.getNotcerReviews();
        long currentTime = getCurrentTime(product.getProductId());
        product.setCurrentTime(currentTime);

        boolean canCont = true;
        for (Element review : reviews) {
            try {
                boolean cer = review.select(".iconcom-checkbuy").size() > 0;
                String dttmStr = review.select(".cmtd").text();
                long createDttm = validDate(dttmStr);
                if (createDttm < 0) {
                    long eslapseDttm = convertStringToTime(dttmStr);
                    createDttm = currentTime - eslapseDttm;
                }
                String reviewId = review.attr("id");
                Elements stars = review.select(".rc span i");
                int rate = 0;
                for (Element star : stars) {
                    if (star.hasClass("iconcom-txtstar")) {
                        rate++;
                    }
                }
                String reviewTxt = review.select(".rc p > i").text();
                String title = product.getTitle();

                if (isCer) {
                    // check condition
                    if (!cer) {
                        canCont = false;
                        break;
                    }
                    // check lastest review
                    if (!isGetAll && (createDttm <= cerReviews.getLastestDttm()
                            || reviewId.equals(cerReviews.getLastestId()))) {
                        canCont = false;
                        break;
                    } else if (createDttm > cerReviews.getLastestDttm()) {
                        cerReviews.setLastestDttm(createDttm);
                        cerReviews.setLastestId(reviewId);
                    }
                    cerReviews.setLength(cerReviews.getLength() + 1);
                } else {
                    if (cer) {
                        continue;
                    }
                    if (!isGetAll && (createDttm <= notcerReviews.getLastestDttm()
                            || reviewId.equals(notcerReviews.getLastestId()))) {
                        canCont = false;
                        break;
                    } else if (createDttm > notcerReviews.getLastestDttm()) {
                        notcerReviews.setLastestDttm(createDttm);
                        notcerReviews.setLastestId(reviewId);
                    }
                    notcerReviews.setLength(notcerReviews.getLength() + 1);
                }

                TRawReview rawReview = new TRawReview(reviewId, reviewTxt, title, rate, createDttm);
                rawReviews.add(rawReview);
            } catch (Exception ex) {
                _Logger.error(ex.getMessage(), ex);
            }
        }

        TRawReviewResult ret = new TRawReviewResult(cerReviews, notcerReviews, rawReviews, canCont);
        return ret;

    }

    private static long convertStringToTime(String timeString) {
        try {
            String[] dttmArr = timeString.trim().split(" ");
            Integer quantity = Integer.valueOf(dttmArr[0]);
            long unit = _timeUnit.get(dttmArr[1]);

            return quantity * unit;
        } catch (Exception ex) {
            _Logger.error(ex.getMessage() + timeString, ex);
            return 0;
        }
    }

    public long validDate(String dateString) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = df.parse(dateString);
            return date.getTime();
        } catch (ParseException ex) {
            _Logger.debug(ex);
            return -1;
        }
    }

    private static class TgddParseProduct implements ParseProduct {

        private static final Pattern _regex = Pattern.compile("(\\/[0-9]+)");
        private static final TReviewMeta _cerReviews = new TReviewMeta(0, "", 0);
        ;
        private static final TReviewMeta _notcerReviews = new TReviewMeta(0, "", 0);

        ;

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

        @Override
        public TProduct parseProductByLink(String productLink) {
            String productHtmlStr = HttpCommon.getWebpage(productLink, _nretry);
            if (productHtmlStr.isEmpty()) {
                _Logger.error("Fail parseProductByLink " + productLink);
                return null;
            }
            Document productHtml = Jsoup.parse(productHtmlStr);
            Elements imgs = productHtml.select("aside.picture img");
            if (imgs.size() > 0) {
                Element img = imgs.first();
                String productId = getProductId(img);
                String title = productHtml.select(".rowtop h1").text();

                TProduct product = new TProduct(productId, productLink, title, _cerReviews, _notcerReviews, 0);
                return product;
            }
            return null;
        }

    }
}
