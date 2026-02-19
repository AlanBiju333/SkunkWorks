package com.skunkworks.pages;

import com.skunkworks.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PIMPage extends BasePage {
    private final By PIMHeader=By.xpath("//h6[text()='PIM']");
    private final By addEmployeeButton=By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Add Employee']");
    private final By firstName=By.cssSelector("[name='firstName']");
    private final By lastName=By.cssSelector("[name='lastName']");
    private final By employeeID=By.xpath("(//*[text()='Employee Id']//following::input)[1]");
    private final By uploadProfilePic=By.xpath("//input[@type='file']");
    private final By saveButton=By.xpath("//*[@type='submit' and text()=' Save ']");
    private final By nameInput=By.xpath("(//input[contains(@placeholder,'Type for hints')])[1]");
    private final By employeeListButton=By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Employee List']");
    private final By searchButton=By.xpath("//*[@type='submit' and text()=' Search ']");
    private final By table=By.xpath("//div[@role='table']");

    public PIMPage(WebDriver driver) {
        super(driver);
    }
    public boolean isPIMPagevisible(){
        return isDisplayed(PIMHeader);
    }
    public void addNewEmployee(String fName,String lName, String empId,String picName){
        click(addEmployeeButton);
        clearAndEnterText(firstName,fName);
        clearAndEnterText(lastName,lName);
        clearAndEnterText(employeeID,empId);
        uploadFile(uploadProfilePic,getTestFilePath(picName));
        click(saveButton);
    }
    public void clickPIM(){
        clickLeftNavMenu("PIM");
    }
    public boolean verifyToast(){
        return verifyText("Successfully Saved");
    }
    public void searchEmployee(String name){
     click(employeeListButton);
     clearAndEnterText(nameInput,name);
     click(searchButton);
    }
    public boolean isEmployeePresent(String name) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(table, name));
        return driver.findElement(table).getText().contains(name);
    }
}
