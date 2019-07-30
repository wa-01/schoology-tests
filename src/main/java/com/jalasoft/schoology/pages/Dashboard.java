package com.jalasoft.schoology.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPage{

    @FindBy(css = ".smartbox-boxtab")
    private WebElement clickEventLink;


    public Dashboard clickTheEventLink(){
        action.click(clickEventLink);
        return new Dashboard();
    }

}
