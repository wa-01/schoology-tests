package com.jalasoft.schoology.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile extends AbstractPage{

    @FindBy(css = ".page-title")
    private WebElement pageTitle;

    public String getPageTitleAccount(){
        return action.getText(pageTitle);
    }
}
