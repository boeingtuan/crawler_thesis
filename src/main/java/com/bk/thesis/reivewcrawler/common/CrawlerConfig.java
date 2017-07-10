package com.bk.thesis.reivewcrawler.common;

/**
 *
 * @author boeingtuan
 */
public class CrawlerConfig {
    
    private String prefixId;
    private int maxProductPage;

    public String getPrefixId() {
        return prefixId;
    }

    public void setPrefixId(String prefixId) {
        this.prefixId = prefixId;
    }

    public int getMaxProductPage() {
        return maxProductPage;
    }

    public void setMaxProductPage(int maxProductPage) {
        if (maxProductPage > 0) {
            this.maxProductPage = maxProductPage;
        } else {
            this.maxProductPage = 1;
        }
    }
}
