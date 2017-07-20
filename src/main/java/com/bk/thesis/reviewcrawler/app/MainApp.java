package com.bk.thesis.reviewcrawler.app;

import com.bk.thesis.configer.ZConfig;
import org.apache.log4j.Logger;

/**
 *
 * @author boeingtuan
 */
public class MainApp {

    private static final Class ThisClass = MainApp.class;
    private static final Logger _Logger = Logger.getLogger(ThisClass);

    public static void main(String[] args) {
        while (true) {
            _Logger.info("Application starting ...");
            try {
                System.out.println(ZConfig.Instance.getBoolean(ThisClass, "test", "test", false));
                Thread.sleep(1000);
            } catch (InterruptedException ex) {                
            }
        }
    }
}
