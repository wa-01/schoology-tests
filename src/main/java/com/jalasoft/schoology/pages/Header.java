package com.jalasoft.schoology.pages;

import com.jalasoft.schoology.pages.Courses.CoursesMenu;
import com.jalasoft.schoology.pages.groups.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {

    private final static String TAB_NAME = "//div[@aria-live='polite']//span[text()='%s']";

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

    public CoursesMenu clickHeaderCoursesMenu() {
        action.click(coursesMenu);
        return new CoursesMenu();
    }


    public Groups clickGroupsMenu() {
        action.click(By.xpath(String.format(TAB_NAME, "Groups")));
        return new Groups();
    }

    public void clickResourcesMenu() {
        action.click(resourcesMenu);
    }

    public void clickGradesMenuDropdown() {
        action.click(gradesMenuDropdown);
    }

    public void clickIconSearchMenu() {
        action.click(iconSearchMenu);
    }

    public void clickIconCalendarMenu() {
        action.click(iconCalendarMenu);
    }
    public void clickIconMailMenu() {
        action.click(iconMailMenu);
    }
    public void clickIconBellMenu() {
        action.click(iconBellMenu);
    }
}
