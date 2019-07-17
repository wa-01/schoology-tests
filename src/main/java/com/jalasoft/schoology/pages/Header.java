package com.jalasoft.schoology.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends AbstractPage {

    @FindBy(xpath = "//div[@data-sgy-sitenav='header-my-account-menu']")
    private WebElement headerMyAccountMenu;

    @FindBy(xpath = "//div[@aria-live='polite']//span[text()='Courses']")
    private WebElement coursesMenu;

    @FindBy(xpath = "//div[@aria-live='polite']//span[text()='Groups']")
    private WebElement groupsMenu;

    @FindBy(xpath = "//a[@href='/resources' and text()='Resources']")
    private WebElement resourcesMenu;

    @FindBy(xpath = "//button[text()='Grades']")
    private WebElement gradesMenuDropdown;

    @FindBy(css = "symbol#icon-search")
    private WebElement iconSearchMenu;

    @FindBy(css = "symbol#icon-calendar-unselected")
    private WebElement iconCalendarMenu;

    @FindBy(css = "symbol#icon-mail")
    private WebElement iconMailMenu;

    @FindBy(css = "symbol#icon-bell")
    private WebElement iconBellMenu;



    public AccountMenu clickHeaderMyAccountMenu() {
        action.click(headerMyAccountMenu);
        return new AccountMenu();
    }

    public String getMyAccountName() {
        return action.getText(headerMyAccountMenu);
    }

    public void clickCoursesMenu(){
        action.click(coursesMenu);
    }

    public void clickGroupsMenu(){
        action.click(groupsMenu);
    }

    public void clickResourcessMenu(){
        action.click(resourcesMenu);
    }

    public void clickgradesMenuDropdown(){
        action.click(gradesMenuDropdown);
    }

    public void clickiconSearchMenu(){
        action.click(iconSearchMenu);
    }

    public void clickiconCalendarMenu(){
        action.click(iconCalendarMenu);
    }
    public void clickiconMailMenu(){
        action.click(iconMailMenu);
    }
    public void clickiconBellMenu(){
        action.click(iconBellMenu);
    }
}
