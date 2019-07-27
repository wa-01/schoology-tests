package com.jalasoft.schoology.pages.event;

import com.jalasoft.schoology.core.ui.ISteps;
import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EventForm extends AbstractPage {

    private static final String PROFILE_NAME = "//label[contains(text(),'%s')]";

    @FindBy (css = "#edit-title")
    private WebElement eventTitleTextInput;

    @FindBy (css = "#browse-realm-button")
    private WebElement eventBrowseButton;

    @FindBy(css = "input[value='Select']")
    private WebElement eventProfileSelectButton;

    @FindBy(css = "input[value='Create']")
    private WebElement eventCreateButton;

    public void setEventFields(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("title", () -> action.setValue(eventTitleTextInput, data.get("title")));
        strategyMap.put("postTo", () -> selectPostTo(data.get("postTo")));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }
    }

    public EventDetails createProject(Map<String, String> data) {
        setEventFields(data);
        action.click(eventCreateButton);
        return new EventDetails();
    }

    private void selectPostTo(String expectedProfile){
        action.click(eventBrowseButton);
        String eventProfileLocator = String.format(PROFILE_NAME, expectedProfile);
        action.click(By.xpath(eventProfileLocator));
        action.click(eventProfileSelectButton);
    }

}
