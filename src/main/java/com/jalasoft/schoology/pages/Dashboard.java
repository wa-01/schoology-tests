package com.jalasoft.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Dashboard extends AbstractPage {

    @FindBy(css = ".smartbox-boxtab")
    private WebElement clickEventLink;

    @FindBy(css = "a[href='/home/course-dashboard]'")
    private WebElement clickCourseDashboard;

    @FindBy (xpath = "//div[@id='smart-box-content']//div[@style='display: block;']")
    private WebElement eventTitleTextInput;

    public Dashboard clickCourseDashboardTab(){
        action.click(clickCourseDashboard);
        return new Dashboard();
    }

    public Dashboard clickTheEventLink(){
        action.click(clickEventLink);
        return new Dashboard();
    }

}
