package com.skunkworks.tests;

import com.skunkworks.base.BaseTest;
import com.skunkworks.config.SecureDataReader;
import com.skunkworks.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        String userName = SecureDataReader.getUsername();
        String passWord = SecureDataReader.getPassword();

        LoginPage login = new LoginPage(getDriver());
        login.login(userName,passWord);

        Assert.assertTrue(login.isLoginSuccess(),"Login Success");
    }

    @Test
    public void InValidLogin() {
        String userName = "Invalid";
        String passWord = "Invalid";

        LoginPage login = new LoginPage(getDriver());
        login.login(userName,passWord);

        Assert.assertTrue(login.isLoginFailed(),"Login Success");
    }
}
