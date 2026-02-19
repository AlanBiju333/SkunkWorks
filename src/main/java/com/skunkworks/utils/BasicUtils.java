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
    public static int getRandomNumber(int digits) {
        if (digits < 1 || digits > 9) {
            throw new IllegalArgumentException("Keep it between 1 and 9");
        }
        int min = (int) Math.pow(10, digits - 1);
        int range = 9 * min;
        return (int) (Math.random() * range) + min;
    }
    public static String getRandomNumberString(int digits) {
        if (digits < 1) {
            throw new IllegalArgumentException("You need at least 1 digit.");
        }
        StringBuilder sb = new StringBuilder(digits);
        // First digit must be 1-9 to avoid a leading zero

        sb.append((int) (Math.random() * 9) + 1);
        for (int i = 1; i < digits; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }
}
