package com.bk.thesis.reviewcrawler.common;

/**
 *
 * @author boeingtuan
 */
public class CrawlerConfig {
    
    private String prefixId = null;
    private String dbConf = null;
    private int maxProductPage = 0;
    private int limitProductBatchSize = 0;
    private int errorConsThreshold = 3;
    private long timeout = 0;

    public int getErrorConsThreshold() {
        return errorConsThreshold;
    }

    public void setErrorConsThreshold(int errorConsThreshold) {
        this.errorConsThreshold = errorConsThreshold;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public int getLimitProductBatchSize() {
        return limitProductBatchSize;
    }

    public void setLimitProductBatchSize(int limitProductBatchSize) {
        this.limitProductBatchSize = limitProductBatchSize;
    }

    public String getDbConf() {
        return dbConf;
    }

    public void setDbConf(String dbConf) {
        this.dbConf = dbConf;
    }

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
    
    public boolean validate() {
        return !(prefixId == null || dbConf == null ||
                maxProductPage == 0 || limitProductBatchSize == 0 ||
                timeout == 0);
    }
}
