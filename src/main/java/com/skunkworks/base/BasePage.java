package com.skunkworks.base;

import com.skunkworks.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver){
        this.driver=driver;
        long timeout=Long.parseLong(ConfigReader.getProperty("timeout"));
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        this.actions=new Actions(driver);
    }

    protected void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void typeText(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    protected String getText(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected boolean isDisplayed(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    protected void clearAndEnterText(By locator, String text){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    protected void waitForVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected String getTitle(){
        return driver.getTitle();
    }

    protected void actionTypeText(By locator, String text){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.sendKeys(element,text).perform();
    }

    protected void sendKeysWithActions(Keys key){
        actions.sendKeys(key).perform();
    }

    protected void mouseHover(By locator){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(element).perform();
    }

    protected void rightClick(By locator){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.contextClick(element).perform();
    }

    protected void doubleClick(By locator){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.doubleClick(element).perform();
    }

    protected void dragAndDrop(By source,By target){
        WebElement src=wait.until(ExpectedConditions.visibilityOfElementLocated(source));
        WebElement tar=wait.until(ExpectedConditions.visibilityOfElementLocated(target));
        actions.moveToElement(src).clickAndHold().pause(Duration.ofMillis(500)).moveToElement(tar).pause(Duration.ofMillis(500)).release().perform();
    }

    protected void switchToNewWindow() {
        String parent = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
    protected void clickLeftNavMenu(String menu){
        By Menu=By.xpath("//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='"+menu+"']");
        click(Menu);
    }
    protected void uploadFile(By locator, String filePath){
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.sendKeys(filePath);
    }
    protected String getTestFilePath(String fileName) {
        return Paths.get("src", "test", "resources", "testData", fileName).toAbsolutePath().toString();
    }
    protected boolean verifyText(String text){
        By locator=By.xpath("//*[text()='"+text+"']");
        return isDisplayed(locator);
    }
}
