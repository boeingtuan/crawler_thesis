

package com.bk.thesis.reivewcrawler.db;

import com.bk.thesis.conf.ConfigUtils;
import com.typesafe.config.Config;
import org.apache.log4j.Logger;

/**
 *
 * @author boeingtuan
 */
public class MongoDBWrapper {
    
    private static final Class ThisClass = MongoDBWrapper.class;
    private static final Logger _Logger = Logger.getLogger(ThisClass);
    private static final Config _Conf = ConfigUtils.Instance.getConfig();
    
}
