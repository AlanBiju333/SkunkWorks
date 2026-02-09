package com.skunkworks.utils;

import com.skunkworks.factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class BasicUtils {

    public static String generateRandomName(String starter) {
        return starter+"_" + UUID.randomUUID().toString().substring(0, 8);
    }
    public static String capture() {
        WebDriver driver = DriverFactory.getDriver();

        if (driver == null) {
            return null;
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BASE64);
    }
}
