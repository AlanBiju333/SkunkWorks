package com.skunkworks.pages;

import com.skunkworks.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends BasePage {
    private final By dashBoardHeader=By.xpath("//h6[text()='Dashboard']");
    private final By profileDropDown=By.cssSelector(".oxd-userdropdown-tab");
    private final By logoutButton=By.xpath("//a[@class='oxd-userdropdown-link' and text()='Logout']");

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }
    public boolean isDashBoardPageVisible(){
     return isDisplayed(dashBoardHeader);
    }
    public void logout(){
        click(profileDropDown);
        click(logoutButton);
    }
}
