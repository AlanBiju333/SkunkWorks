package com.skunkworks.base;

import com.skunkworks.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();          // reads browser from config & launches it
        driver = DriverFactory.getDriver(); // gives the thread-safe driver
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();          // closes and cleans driver
    }
}
