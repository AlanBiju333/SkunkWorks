package com.skunkworks.pages;

import com.skunkworks.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class PIMPage extends BasePage {
    private final By PIMHeader=By.xpath("//h6[text()='PIM']");
    private final By addEmployeeButton=By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Add Employee']");
    private final By firstName=By.cssSelector("[name='firstName']");
    private final By lastName=By.cssSelector("[name='lastName']");
    private final By uploadProfilePic=By.xpath("//input[@type='file']");
    private final By saveButton=By.xpath("//*[@type='submit' and text()=' Save ']");

    public PIMPage(WebDriver driver) {
        super(driver);
    }
    public boolean isPIMPagevisible(){
        return isDisplayed(PIMHeader);
    }
    public void addNewEmployee(String fName,String lName, String picName){
        click(addEmployeeButton);
        typeText(firstName,fName);
        typeText(lastName,lName);
        uploadFile(uploadProfilePic,getTestFilePath(picName));
        click(saveButton);
    }
    public void clickPIM(){
        clickLeftNavMenu("PIM");
    }
    public boolean verifyToast(){
        return verifyText("Successfully Saved");
    }
}
