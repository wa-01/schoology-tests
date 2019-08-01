package com.jalasoft.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile extends AbstractPage {

    private final static String PROFILE_SECTION = "//th[contains(text(),'%s')]";

    @FindBy(css = ".page-title")
    private WebElement pageTitle;

    @FindBy(xpath = "//th[contains(text(),'Birthday')]//following-sibling::td")
    private WebElement birthdayText;

    @FindBy(xpath = "//span[@class='admin-val email']//child::a")
    private WebElement emailText;

    @FindBy(css = "div[class='profile-btns profile-btns-one']>a")
    private WebElement editButton;

    @FindBy(css = "#tab-nav-interest")
    private WebElement interestsTab;

    @FindBy(css = "#edit-profile-interests-interests")
    private WebElement interestsTextArea;

    @FindBy(css = "#edit-submit")
    private WebElement saveButton;

    @FindBy(xpath = "//th[contains(text(),'Interests')]//following::td")
    private WebElement interestContent;

    public String getPageTitleAccount(){
        return action.getText(pageTitle);
    }

    public String getBirthdayText(){
        return action.getText(birthdayText);
    }
    
    public String getEmailText(){
        return action.getText(emailText);
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

    public void clearField(){
        driver.findElement(By.cssSelector("#edit-profile-interests-interests")).clear();
    }

    public String getInterest(){
        return action.getText(interestContent);
    }
}
