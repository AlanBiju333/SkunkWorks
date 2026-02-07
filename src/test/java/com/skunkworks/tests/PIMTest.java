package com.skunkworks.tests;

import com.skunkworks.base.BaseTest;
import com.skunkworks.pages.PIMPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.skunkworks.utils.BasicUtils;

public class PIMTest extends BaseTest {
    String firstName;
    String lastName;
    @BeforeClass
    public void generateData(){
        firstName=BasicUtils.generateRandomName("Test");
        lastName=BasicUtils.generateRandomName("Test");
    }
    @Test
    public void verifyPIMPage(){
        validLogin();
        PIMPage pim=new PIMPage(getDriver());
        pim.clickPIM();
        Assert.assertTrue(pim.isPIMPagevisible(),"PIM page loaded successfully");
    }
    @Test
    public void verifyCreateEmployee(){
        validLogin();
        PIMPage pim=new PIMPage(getDriver());
        pim.clickPIM();
        pim.addNewEmployee(firstName,lastName,"profilePic.png");
        Assert.assertTrue(pim.verifyToast());
    }
}
