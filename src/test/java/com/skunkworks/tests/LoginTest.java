package com.skunkworks.tests;

import com.skunkworks.base.BaseTest;
import com.skunkworks.config.ConfigReader;
import com.skunkworks.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        String userName = ConfigReader.getProperty("userName");
        String passWord = ConfigReader.getProperty("password");

        LoginPage login = new LoginPage(getDriver());
        login.login(userName,passWord);

        Assert.assertTrue(login.isLoginSuccess(),"Login Success");
    }
}
