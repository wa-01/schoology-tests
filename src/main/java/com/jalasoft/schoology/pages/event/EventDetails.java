package com.jalasoft.schoology.pages.event;

import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EventDetails extends AbstractPage {

    private static final String HOME_URL = "https://app.schoology.com/home";

    @FindBy(css = "a[href='/home/recent-activity']")
    private WebElement recentActivityPage;

    @FindBy(xpath = "//div[@class='upcoming-list']//child::div//a")
    private WebElement eventTitleLabel;

    @FindBy(xpath = "//div[contains(text(),'(Today')]//parent::div//parent::td")
    private WebElement clickCalendarToday;

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
        driver.get(HOME_URL);
    }

    public void waitSomeSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

}
