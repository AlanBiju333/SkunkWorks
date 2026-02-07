package com.skunkworks.base;

import com.skunkworks.config.ConfigReader;
import com.skunkworks.config.SecureDataReader;
import com.skunkworks.factory.DriverFactory;
import com.skunkworks.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

    protected void validLogin() {
        String userName = SecureDataReader.getUsername();
        String passWord = SecureDataReader.getPassword();

        if (userName == null || userName.isEmpty()
                || passWord == null || passWord.isEmpty()) {
            throw new RuntimeException("Credentials not found. Set environment variables or provide sensitive.properties");
        }
        LoginPage login = new LoginPage(getDriver());
        login.login(userName,passWord);
        if(!login.isLoginSuccess()){
            throw new AssertionError("Login failed with provided credentials");
        }
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();          // closes and cleans driver
    }
}
