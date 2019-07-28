package com.jalasoft.schoology.pages.event;

import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EventDetails extends AbstractPage {

    private static final String EVENT_TITLE = "//a[contains(text(),'%s')]";

    @FindBy(css = "a[href='/home/recent-activity']")
    private WebElement recentActivityPage;

    @FindBy(xpath = "//div[@class='upcoming-list']//child::div//a")
    private WebElement eventTitleLabel;

    @FindBy(xpath = "//div[contains(text(),'(Today')]//parent::div//parent::td")
    private WebElement clickCalendarToday;

    String homeURL = "https://app.schoology.com/home";

    @FindBy(css = "a[title='View user profile.']")
    private WebElement createdByName;

    public void goToRecentActivityPage(){
        action.click(recentActivityPage);
    }

    public String getEventTitleLabel() {
        return action.getText(eventTitleLabel);
    }

    public void startCreatingEventToday(){
        action.click(clickCalendarToday);
    }

    public void goToHomePage(){
        driver.get(homeURL);
    }

    public void selectEvent(String eventTitle){
        String eventTitleLocator = String.format(EVENT_TITLE, eventTitle);
        action.click(By.xpath(eventTitleLocator));
    }

    public String getCreatedByName(){
        return action.getText(createdByName);
    }
}
