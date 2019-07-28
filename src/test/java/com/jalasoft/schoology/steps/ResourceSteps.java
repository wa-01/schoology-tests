package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.Header;
import com.jalasoft.schoology.pages.Resource;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class ResourceSteps {

    private Header header;
    private Resource resource;

    public ResourceSteps(Header header, Resource resource) {
        this.header = header;
        this.resource = resource;
    }

    @When("I click the \"Resources\" button")
    public void iClickResourcesButton(){
        header.clickResourcesMenu();
    }

    @And("I click the \"Add Resources\" dropdown")
    public void iClickAddResourcesButton(){
        resource.clickAddResourcesButton();
    }

    @And("I click the \"Add Folder\" button")
    public void iClickAddFolderButton(){
        resource.clickAddFolderButton();
    }

    @And("I add name {string} to folder")
    public void iAddNameToFolder(String folderName){
        resource.addFolderName(folderName);
    }

    @And("I click the \"Create\" button")
    public void iClickTheCreateButton(){
        resource.clickCreateButton();
    }

    @Then("I validate {string} folder is available")
    public void iValidateFolderIsAvailable(String folderName){
        String createdFolderName = resource.getFolderName();
        assertEquals(createdFolderName, folderName);
    }


}
