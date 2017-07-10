package com.bk.thesis.reviewcrawler.app;

import com.bk.thesis.conf.ConfigUtils;
import com.typesafe.config.Config;
import org.apache.log4j.Logger;

/**
 *
 * @author boeingtuan
 */
public class MainApp {

    private static final Class ThisClass = MainApp.class;
    private static final Logger _Logger = Logger.getLogger(ThisClass);
    private static final Config _Conf = ConfigUtils.Instance.getConfig();

    public static void main(String[] args) {
        _Logger.info("Application starting ...");

    }
}
