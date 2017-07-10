package com.bk.thesis.reivewcrawler.common;

/**
 *
 * @author boeingtuan
 */
public class Product {

    private String productId;
    private String url;
    private String title;
    private Long latestReviewDttm;

    public Product(String productId, String url, String title) {
        this.productId = productId;
        this.url = url;
        this.title = title;
        this.latestReviewDttm = 0L;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getLatestReviewDttm() {
        return latestReviewDttm;
    }

    public void setLatestReviewDttm(Long latestReviewDttm) {
        this.latestReviewDttm = latestReviewDttm;
    }
}
