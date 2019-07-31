package com.jalasoft.schoology.pages.groups;

import com.jalasoft.schoology.core.ui.ISteps;
import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GroupsForm extends AbstractPage {

    private final static String PRIVACY_OPTION = "//select[@name='privacy_level']//option[@value='%s']";
    private final static String ACCESS_OPTION = "//select[@name='invite_type']//option[@value='%s']";
    private final static String CATEGORY_OPTION = "//select[@name='category']//option[@value='%s']";

    @FindBy(xpath = "//label[@for='edit-name']//parent::div/input")
    private WebElement groupNameTextArea;

    @FindBy(css = "#edit-submit")
    private WebElement creteButton;

    @FindBy(xpath = "//label[@for='edit-privacy-level']//parent::div/select[@name='privacy_level']")
    private WebElement privacyLevelSelect;

    @FindBy(xpath = "//label[@for='edit-description']//parent::div/textarea")
    private WebElement groupDescriptionTextArea;

    @FindBy(css = "span.group-title")
    private WebElement backToGroupLink;

    public Object addGroups(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("edit-name", () -> action.clearAndSetValue(groupNameTextArea, data.get("edit-name")));
        strategyMap.put("edit-description", () -> action.clearAndSetValue(groupDescriptionTextArea, data.get("edit-description")));
        strategyMap.put("privacy_level" , ()-> addPrivacy(data.get("privacy_level")));
        strategyMap.put("invite_type", ()-> addInviteType(data.get("invite_type")));
        strategyMap.put("category", ()-> addCategory(data.get("category")));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }


        action.click(creteButton);

        // This needs to be removed
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new GroupDetail();
    }

    private void addPrivacy(String privacy_level) {
        action.click(privacyLevelSelect);
        action.click(By.xpath(String.format(PRIVACY_OPTION, privacy_level)));
    }
    private void addInviteType(String invite_type) {
        action.click(privacyLevelSelect);
        action.click(By.xpath(String.format(ACCESS_OPTION, invite_type)));
    }
    private void addCategory(String category) {
        action.click(privacyLevelSelect);
        action.click(By.xpath(String.format(CATEGORY_OPTION, category)));
    }

    public void clickBackToGroupLink() {
        action.click(backToGroupLink);
    }
}
