package com.skunkworks.tests;

import com.skunkworks.base.BaseTest;
import com.skunkworks.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest extends BaseTest {//since BaseTest is extended, testng will run the before and after method automatically
    //as it will always run the class and its parent's before and after methods.

    @Test
    public void launchOrangeHRM() {
        driver.get(ConfigReader.getProperty("url"));
        System.out.println("Page Title: " + driver.getTitle());
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-v-10d463b7]")));
        if(login.isDisplayed()){
            System.out.println("Login success");
        }else{
            System.out.println("login failed");
        }
        driver.quit();
    }
}
