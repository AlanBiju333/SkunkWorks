package com.skunkworks.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static Properties loadProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
                properties.load(fis);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load config.properties file");
            }
        }
        return properties;
    }

    public static String getProperty(String key) {
        return loadProperties().getProperty(key);
    }

}
