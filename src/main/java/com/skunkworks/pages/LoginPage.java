package com.skunkworks.pages;

import com.skunkworks.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By userNameInput= By.xpath("//*[@name='username']");
    private final By passwordInput= By.xpath("//*[@name='password']");
    private final By loginButton= By.xpath("//button[@type='submit']");
    private final By profilePic=By.cssSelector(".oxd-userdropdown-img[alt='profile picture']");
    private final By invalidCredentialsMsg= By.xpath("//*[text()='Invalid credentials']");

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

    public boolean isLoginFailed(){
        return isDisplayed(invalidCredentialsMsg);
    }

    public boolean isLoginPageVisible(){
        return isDisplayed(loginButton);
    }
}
