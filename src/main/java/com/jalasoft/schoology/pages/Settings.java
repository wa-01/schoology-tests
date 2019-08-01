package com.jalasoft.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Settings extends AbstractPage {

    @FindBy(xpath = "//label[contains(text(),'Middle Name: ')]//following-sibling::input")
    private WebElement middleName;

    public void addSettingValue(String settingValue){
        action.setValue(middleName, settingValue);
    }

    public void clearSettingContent(){
        driver.findElement(By.cssSelector("input[name='user[name_middle]']")).clear();
    }
}
