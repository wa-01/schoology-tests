package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.AccountMenu;
import com.jalasoft.schoology.pages.Header;
import com.jalasoft.schoology.pages.groups.GroupDetail;
import com.jalasoft.schoology.pages.groups.Groups;
import com.jalasoft.schoology.pages.groups.GroupsForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class GroupsSteps {

    private AccountMenu accountMenu;
    private Groups groups;
    private GroupsForm groupsForm;
    private GroupDetail groupDetail;

    public GroupsSteps(AccountMenu accountMenu, Groups groups, GroupsForm groupsForm, GroupDetail groupDetail) {
        this.accountMenu= accountMenu;
        this.groups= groups;
        this.groupsForm= groupsForm;
        this.groupDetail= groupDetail;
    }

    @When("I click My Groups link")
    public void iClickMyGroupsLink() {
        groups.clickMyGroupsLink();
    }


    @When("I add Group With:")
    public void iAddGroupWith(Map<String, String> data) {
        groupDetail = groups.clickMyGroupsLink();
        groupDetail.clickCreateGroupButton();
        groupsForm.addGroups(data);
    }

    @Then("I validate group title is {string}")
    public void iValidateGroupTitleIs(String expectedGroupName) {
        assertEquals(expectedGroupName, groupDetail.getGroupTitleName());
    }

    @And("I validate group information {string}")
    public void iValidateGroupInformation(String expectedGroupInformation) {
        assertEquals(expectedGroupInformation, groupDetail.getGroupDescription());
    }

    @And("I validate group Category {string}")
    public void iValidateGroupCategory(String expectedCategory) {
        assertEquals(expectedCategory, groupDetail.getGroupCategory());
    }

    @And("I edit group info with:")
    public void iEditGroupInfoWith(Map<String, String> data) {
        groupDetail.selectGroupOptions("Edit Info");
        groupsForm.addGroups(data);
    }

    @And("I click back to Group link")
    public void iClickBackToGroupLink() {
        groupsForm.clickBackToGroupLink();
    }
}
