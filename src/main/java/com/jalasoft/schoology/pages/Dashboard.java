package com.jalasoft.schoology.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPage{

    @FindBy(css = ".smartbox-boxtab")
    private WebElement clickEventLink;

    @FindBy (css = "a[href='/user-calendar']")
    private WebElement clickCalendarLink;


    public Dashboard clickTheEventLink(){
        action.click(clickEventLink);
        return new Dashboard();
    }

    public Dashboard clickTheCalendarLink() {
        action.click(clickCalendarLink);
        return new Dashboard();
    }

}
