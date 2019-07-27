package com.jalasoft.schoology.pages.event;

import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventDetails extends AbstractPage {

    @FindBy(css = "a[href='/home/recent-activity']")
    private WebElement recentActivityPage;

    @FindBy(xpath = "//div[@class='upcoming-event user-event upcoming-subevents-block']//a[2]")
    private WebElement eventTitleLabel;

    public void goToRecentActivityPage(){
        action.click(recentActivityPage);
    }

    public String getEventTitleLabel() {
        return action.getText(eventTitleLabel);
    }
}
