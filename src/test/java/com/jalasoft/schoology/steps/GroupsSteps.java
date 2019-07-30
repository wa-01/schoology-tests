package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.AccountMenu;
import com.jalasoft.schoology.pages.Header;
import com.jalasoft.schoology.pages.groups.Groups;
import com.jalasoft.schoology.pages.groups.GroupsForm;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class GroupsSteps {

    private AccountMenu accountMenu;
    private Groups groups;
    private GroupsForm groupsForm;

    public GroupsSteps(AccountMenu accountMenu, Groups groups, GroupsForm groupsForm) {
        this.accountMenu= accountMenu;
        this.groups= groups;
        this.groupsForm= groupsForm;
    }

    @When("I add Group With:")
    public void iAddGroupWith(Map<String, String> data) {
        groups.clickAddGroupsButton();
        groupsForm.addGroups(data);
    }
}
