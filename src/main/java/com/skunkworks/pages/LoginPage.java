package com.skunkworks.pages;

import com.skunkworks.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By userNameInput= By.xpath("//*[@name='username']");
    private final By passwordInput= By.xpath("//*[@name='password']");
    private final By loginButton= By.xpath("//*[@data-v-10d463b7]");
    private final By profilePic=By.xpath("//*[@data-v-bdd6d943 and @alt='profile picture']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password){
        clearAndEnterText(userNameInput, userName);
        clearAndEnterText(passwordInput, password);
        click(loginButton);
    }

    public boolean isLoginSuccess(){
        return isDisplayed(profilePic);
    }
}
