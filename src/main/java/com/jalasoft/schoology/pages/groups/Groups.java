package com.jalasoft.schoology.pages.groups;

import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Groups extends AbstractPage {

    @FindBy(xpath = "//span[text()='Create a Group']")
    private WebElement addGroupsButton;

    @FindBy(xpath = "//h2[text()='Groups']/following-sibling::a[@href='/groups']")
    private WebElement myGroupsLink;

    public GroupsForm clickAddGroupsButton() {
        action.click(addGroupsButton);
        return new GroupsForm();
    }

    public GroupDetail clickMyGroupsLink() {
        action.click(myGroupsLink);
        return new GroupDetail();
    }
}
