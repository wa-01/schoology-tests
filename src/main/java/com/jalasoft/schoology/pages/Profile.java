package com.jalasoft.schoology.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile extends AbstractPage{

    @FindBy(css = ".page-title")
    private WebElement pageTitle;

    @FindBy(css = "div[class='profile-btns profile-btns-one']")
    private WebElement editButton;

    @FindBy(css = "#tab-nav-interest")
    private WebElement interestsTab;

    @FindBy(css = "#edit-profile-interests-interests")
    private WebElement interestsTextArea;

    @FindBy(css = "#edit-submit")
    private WebElement saveButton;

    public String getPageTitleAccount(){
        return action.getText(pageTitle);
    }

    public void clickEditButton(){
        action.click(editButton);
    }

    public void goToInterestsTab(){
        action.click(interestsTab);
    }

    public void addInterest(String interest){
        action.setValue(interestsTextArea, interest);
    }

    public void clickSaveButton(){
        action.click(saveButton);
    }
}
