package com.jalasoft.schoology.pages.Courses;

import com.jalasoft.schoology.core.ui.ISteps;
import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CreateFolder extends AbstractPage {

    @FindBy (css = "#edit-title")
    private WebElement folderTitle;

   @FindBy (css = "input[id='edit-submit']")
    private WebElement saveFolder;

    public static final String FOLDER_COLOR = "div[class*='clickable s-js-color-select'][data-color='%s']";

    public CourseCenterWrapper createFolder(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("folder_title", () -> action.setValue(folderTitle, data.get("folder_title")));
        strategyMap.put("folder_color", () -> setFolderColor(data.get("folder_color")));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }

        action.click(saveFolder);
        return new CourseCenterWrapper();
    }

    public void setFolderColor(String color){
        action.click(By.cssSelector(String.format(FOLDER_COLOR,color)));
    }
}