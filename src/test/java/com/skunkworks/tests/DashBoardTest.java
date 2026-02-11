package com.skunkworks.tests;

import com.skunkworks.base.BaseTest;
import com.skunkworks.pages.DashBoardPage;
import com.skunkworks.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashBoardTest extends BaseTest {

    @Test
    public void verifyDashBoardPage(){
        validLogin();
        DashBoardPage dash=new DashBoardPage(getDriver());
        Assert.assertTrue(dash.isDashBoardPageVisible(),"Dashboard page loaded successfully");
    }
    @Test
    public void verifyLogout(){
        validLogin();
        DashBoardPage dash=new DashBoardPage(getDriver());
        dash.logout();
        LoginPage login=new LoginPage(getDriver());
        Assert.assertTrue(login.isLoginPageVisible(),"Logout success");
    }
}
