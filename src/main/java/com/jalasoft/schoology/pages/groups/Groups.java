package com.jalasoft.schoology.pages.groups;

import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Groups extends AbstractPage {

    @FindBy(xpath = "//span[text()='Create a Group']")
    private WebElement addGroupsButton;

    public GroupsForm clickAddGroupsButton() {
        action.click(addGroupsButton);
        return new GroupsForm();
    }
}
