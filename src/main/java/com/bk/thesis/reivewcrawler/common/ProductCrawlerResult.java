

package com.bk.thesis.reivewcrawler.common;

/**
 *
 * @author boeingtuan
 */
public class ProductCrawlerResult {
    
    private int size;
    private long time;

    public ProductCrawlerResult(int size, long time) {
        this.size = size;
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public ProductCrawlerResult(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
