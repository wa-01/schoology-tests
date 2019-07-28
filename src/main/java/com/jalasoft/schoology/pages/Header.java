package com.jalasoft.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends AbstractPage {

    private final static String TAB_NAME = "//div[@aria-live='polite']//span[text()='%s']";
    private final static String ACCOUNT_LINK = "//a[contains(text(),'%s')]";

    @FindBy(xpath = "//div[@data-sgy-sitenav='header-my-account-menu']")
    private WebElement headerMyAccountMenu;

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
        action.click(By.xpath(String.format(TAB_NAME, "Groups")));
    }

    public void clickGroupsMenu(){
        action.click(By.xpath(String.format(TAB_NAME, "Resources")));
    }

    public void clickResourcesMenu(){
        action.click(resourcesMenu);
    }

    public void clickGradesMenuDropdown(){
        action.click(gradesMenuDropdown);
    }

    public void clickIconSearchMenu(){
        action.click(iconSearchMenu);
    }

    public void clickIconCalendarMenu(){
        action.click(iconCalendarMenu);
    }
    public void clickIconMailMenu(){
        action.click(iconMailMenu);
    }
    public void clickIconBellMenu(){
        action.click(iconBellMenu);
    }
    public void clickAccountLink(String link){
        String accountLinkLocator = String.format(ACCOUNT_LINK, link);
        action.click(By.xpath(accountLinkLocator));
    }

}
