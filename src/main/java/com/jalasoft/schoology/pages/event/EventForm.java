package com.jalasoft.schoology.pages.event;

import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventForm extends AbstractPage {

    private static final String PROFILE_NAME = "//label[contains(text(),'%s')]";

    @FindBy(css = "#browse-realm-button")
    private WebElement eventBrowseButton;

    @FindBy(css = "input[value='Select']")
    private WebElement eventProfileSelectButton;

    @FindBy(css = "#edit-submit")
    private WebElement eventCreateButton;


    public EventDetails setEventTitle(String title) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.findElement(By.id("edit-title")).sendKeys(title);
        return new EventDetails();
    }

    public EventDetails setEventPostTo(String profile){
        action.click(eventBrowseButton);
        String eventProfileLocator = String.format(PROFILE_NAME, profile);
        action.click(By.xpath(eventProfileLocator));
        action.click(eventProfileSelectButton);
        return new EventDetails();
    }

    public EventDetails pressButton(){
        action.click(eventCreateButton);
        return new EventDetails();
    }
}
