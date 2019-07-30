package com.jalasoft.schoology.pages.groups;

import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GroupDetail extends AbstractPage {

    private final static String GROUP_OPTION = "//a[contains(@class,'sExtlink-processed') and text() = '%s']";

    @FindBy(css = "a[href='/groups/new']")
    private WebElement createGroupButton;

    @FindBy(css = "span[class='group-title']>a")
    private WebElement groupTitle;

    @FindBy(css = "p[class='group-info']")
    private WebElement groupDescription;

    @FindBy(css = "div[class='group-info-wrapper sGroup-processed']>dl>dd")
    private WebElement groupCategory;

    @FindBy(css = "span.action-links-unfold-text  ")
    private WebElement groupOptionsDropdown;

    public GroupsForm clickCreateGroupButton() {
        action.click(createGroupButton);
        return new GroupsForm();
    }

    public String getGroupTitleName() {
        return action.getText(groupTitle);
    }

    public String getGroupDescription() {
        return action.getText(groupDescription);
    }

    public String getGroupCategory() {
        return action.getText(groupCategory);
    }

    public GroupsForm selectGroupOptions(String editInfo) {
        action.click(groupOptionsDropdown);
        action.click(By.xpath(String.format(GROUP_OPTION, editInfo)));
        return new GroupsForm();
    }
}
