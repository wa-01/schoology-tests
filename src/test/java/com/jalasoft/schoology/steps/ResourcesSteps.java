package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.Header;
import com.jalasoft.schoology.pages.Resource;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class ResourcesSteps {

    private Header header;
    private Resource resource;

    @Given("I click the Resources button")
    public void iClickResourcesButton(){
        header = new Header();
        header.clickResourcesMenu();
    }

    @When("I click the Add Resources dropdown")
    public void iClickAddResourcesButton(){
        resource = new Resource();
        resource.clickAddResourcesButton();
    }

    @And("I click the {string} resource button")
    public void iClickAddFolderButton(String resourceName){
        resource = new Resource();
        resource.clickAddResourceButton(resourceName);
    }

    @And("I add name {string} to folder")
    public void iAddNameToFolder(String folderName){
        resource = new Resource();
        resource.addFolderName(folderName);
    }

    @And("I click the Create button")
    public void iClickTheCreateButton(){
        resource = new Resource();
        resource.clickCreateButton();
    }

    @Then("I validate {string} folder is available")
    public void iValidateFolderIsAvailable(String folderName){
        resource = new Resource();
        String createdFolderName = resource.getFolderName();
        assertEquals(createdFolderName, folderName);
    }

    @When("I click the {string} resource checkbox")
    public void iClickTheResourceCheckbox(String resourceName){
        resource = new Resource();
        resource.clickResourceCheckbox(resourceName);
    }

    @And("I click the resource Edit button")
    public void iClickTheResourceEditButton(){
            resource = new Resource();
            resource.clickResourceEditButton();

    }

    @And("I click the resource Delete button")
    public void iClickTheResourceDeleteButton(){
        resource = new Resource();
        resource.clickResourceDeleteButton();
    }

    @And("I click the Delete button to confirm")
    public void iClickTheDeleteButton() {
        resource = new Resource();
        resource.clickDeleteButton();
    }

    @And("I add URL {string} link")
    public void iAddLinkResource(String urlResource){
        resource.addLinkResource(urlResource);
    }

    @And("I add URL {string} title")
    public void iAddUrlTitle(String urlTitle){
        resource.addLinkTitle(urlTitle);
    }

    @And("I click the \"Add\" button")
    public void iClickAddButton(){
        resource.clickAddButton();
    }

    @Then("I validate {string} link is available")
    public void iValidateLinkIsAvailable(String urlTitle){
        String createdUrlTitle = resource.getUrlTitle();
        assertEquals(createdUrlTitle, urlTitle);
    }
}
