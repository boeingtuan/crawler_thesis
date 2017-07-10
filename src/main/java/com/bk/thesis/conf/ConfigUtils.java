package com.bk.thesis.conf;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author boeingtuan
 */
public class ConfigUtils {

    public static final ConfigUtils Instance = new ConfigUtils();
    private Config _conf = null;

    public Config getConfig() {
        if (_conf == null) {
            _conf = createConfigObject();
        }
        return _conf;
    }

    public Config createConfigObject() {
        return createConfigObject("conf/application.conf");
    }

    public Config createConfigObject(String configPath) {
        Config config = null;
        if (configPath == null) {
            config = ConfigFactory.defaultReference();
        } else {
            if (configPath.startsWith("classpath:")) {
                if (configPath.length() < 11) {
                    throw new IllegalArgumentException("configPath seems not right");
                }
                try (InputStream in = ClassLoader.getSystemClassLoader()
                        .getResourceAsStream(configPath.substring(10))) {
                    config = ConfigFactory.parseReader(new InputStreamReader(in));
                } catch (IOException e) {
                }
            } else {
                File configFile = new File(configPath);
                if (!configFile.exists() || configFile.isDirectory()) {
                    throw new IllegalArgumentException(
                            "Config file doesn't exist or it's directory");
                }
                config = ConfigFactory.parseFile(configFile);
            }
            config.withFallback(ConfigFactory.defaultReference());
        }
        return config;
    }

}
