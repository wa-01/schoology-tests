package com.jalasoft.schoology.pages;

import com.jalasoft.schoology.pages.event.EventDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Settings extends AbstractPage {

    @FindBy (xpath = "//label[contains(text(),'Middle Name: ')]//following-sibling::input")
    private WebElement middleName;

    public void addSettingValue(String settingValue){
        action.setValue(middleName, settingValue);

    }


}
