package com.bk.thesis.reviewcrawler.common;

import com.bk.thesis.reviewcrawler.model.BaseCrawlerModel;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author boeingtuan
 */
public class HttpCommon {

    private static final Class ThisClass = BaseCrawlerModel.class;
    private static final Logger _Logger = Logger.getLogger(ThisClass);

    private static final CloseableHttpClient httpClient;

    static {
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(3, TimeUnit.MINUTES);
//        manager.setMaxTotal(20);
        httpClient = HttpClients.custom()
                .setConnectionManager(manager)
                .build();
    }

    public static String getWebpage(String url, int nretry) {
        try {
            URI uri = new URIBuilder(url)
                    .build();
            HttpGet getReq = new HttpGet(uri);
            getReq.setHeader("Content-Type", "application/x-www-form-urlencoded");
            getReq.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) "
                    + "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 "
                    + "Safari/537.36");

            for (int i = 0; i < nretry; i++) {
                HttpResponse response = httpClient.execute(getReq);
                HttpEntity entity = response.getEntity();
                StatusLine status = response.getStatusLine();
                if (status.getStatusCode() == HttpStatus.SC_OK && entity != null) {
                    String pageData = EntityUtils.toString(entity);
                    return pageData;
                } else {
                    Thread.sleep(500);
                }
                getReq.releaseConnection();
            }
            _Logger.error("Fail to get webpage: " + url + " ");
            return "";
        } catch (URISyntaxException | IOException | InterruptedException ex) {
            _Logger.error(ex.getMessage(), ex);
            return "";
        }
    }
}
