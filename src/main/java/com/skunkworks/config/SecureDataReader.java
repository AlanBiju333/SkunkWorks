package com.skunkworks.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SecureDataReader {
    private static Properties properties;

    private static Properties loadSecureFile() {
        if (properties == null) {
            properties = new Properties();
            try (FileInputStream fis =
                         new FileInputStream("src/main/resources/sensitive.properties")) {
                properties.load(fis);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load sensitive.properties file");
            }
        }
        return properties;
    }
    public static String getUsername() {
        String username = System.getenv("TEST_USERNAME");
        if (username != null && !username.isEmpty()) {
            return username;
        }else {
            return loadSecureFile().getProperty("userName");
        }
    }

    public static String getPassword() {
        String password = System.getenv("TEST_PASSWORD");
        if (password != null && !password.isEmpty()) {
            return password;
        }else {
            return loadSecureFile().getProperty("password");
        }
    }

}
