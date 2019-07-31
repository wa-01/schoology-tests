package com.jalasoft.schoology.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile extends AbstractPage {

    @FindBy(css = ".page-title")
    private WebElement pageTitle;

    @FindBy(xpath = "//th[contains(text(),'Birthday')]//following-sibling::td")
    private WebElement birthdayText;

    @FindBy(xpath = "//span[@class='admin-val email']//child::a")
    private WebElement emailText;

    public String getPageTitleAccount(){
        return action.getText(pageTitle);
    }
    public String getBirthdayText(){
        return action.getText(birthdayText);
    }
    public String getEmailText(){
        return action.getText(emailText);
    }
}
