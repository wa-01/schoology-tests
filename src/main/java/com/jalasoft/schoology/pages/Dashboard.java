package com.jalasoft.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPage{

    private static final String COURSE_NAME = "//div[contains(text(),'%s')]";
    private static final String SETTING_OPTION = "//a[contains(text(),'%s')]";

    @FindBy(css = ".smartbox-boxtab")
    private WebElement clickEventLink;

    @FindBy (css = "a[href='/user-calendar']")
    private WebElement clickCalendarLink;

    @FindBy (css = "h2[class='page-title ']")
    private WebElement pageTitle;

    @FindBy(css = "a[href='/home/course-dashboard']")
    private WebElement clickCourseDashboard;

    @FindBy(css = ".page-title ")
    private WebElement courseName;

    @FindBy(css = "span[class='action-links-unfold-text  ']")
    private WebElement eventSettingsButton;

    @FindBy(css = "input[value='Delete']")
    private WebElement deleteButton;

    public Dashboard clickTheEventLink(){
        action.click(clickEventLink);
        return new Dashboard();
    }
    public Dashboard clickTheCalendarLink() {
        action.click(clickCalendarLink);
        return new Dashboard();
    }
    public String getPageTitle(){
        return action.getText(pageTitle);
    }

    public Dashboard clickCourseDashboardTab(){
        action.click(clickCourseDashboard);
        return new Dashboard();
    }
    public void selectCourse(String courseName){
        String courseLocator = String.format(COURSE_NAME, courseName);
        action.click(By.xpath(courseLocator));
    }
    public void clickEventSettingsButton(){
        action.click(eventSettingsButton);
    }
    public void selectSettingOption(String option){
        String settingOptionLocator = String.format(SETTING_OPTION, option);
        action.click(By.xpath(settingOptionLocator));
    }
    public void pressDeleteButton(){
        action.click(deleteButton);
    }
}
