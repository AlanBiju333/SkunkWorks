package com.skunkworks.factory;

import com.skunkworks.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();//helps to assign individual browser instances to each test, erasing clashes

    public static void initDriver() {
        String browser = ConfigReader.getProperty("browser");
        switch (browser.toLowerCase()) {

            case "chrome":
                tlDriver.set(new ChromeDriver());
                break;

            case "firefox":
                tlDriver.set(new FirefoxDriver());
                break;

            case "edge":
                tlDriver.set(new EdgeDriver());
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
            driver.quit();
            tlDriver.remove();
        }
    }
}
