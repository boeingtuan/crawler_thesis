

package com.bk.thesis.reivewcrawler.common;

/**
 *
 * @author boeingtuan
 */
public class ProductsPage {
    
    private boolean exist;
    private String pageData;

    public String getPageData() {
        return pageData;
    }

    public void setPageData(String pageData) {
        this.pageData = pageData;
    }

    public ProductsPage(boolean exist) {
        this.exist = exist;
    }
    
    public ProductsPage(boolean exist, String pageData) {
        this.exist = exist;
        this.pageData = pageData;
    }
    
    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
}
