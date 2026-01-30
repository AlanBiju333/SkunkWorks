package com.skunkworks.base;

import com.skunkworks.config.ConfigReader;
import com.skunkworks.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();          // reads browser from config & launches it
        driver = DriverFactory.getDriver(); // gives the thread-safe driver
        String URL= ConfigReader.getProperty("url");
        driver.get(URL);
        driver.manage().window().maximize();
    }
    protected WebDriver getDriver(){
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();          // closes and cleans driver
    }
}
