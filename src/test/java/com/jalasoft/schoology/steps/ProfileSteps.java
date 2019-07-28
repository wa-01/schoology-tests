package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.AbstractPage;
import com.jalasoft.schoology.pages.Dashboard;
import com.jalasoft.schoology.pages.Header;
import com.jalasoft.schoology.pages.Profile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class ProfileSteps extends AbstractPage {

    private Header header;
    private Profile profile;
    private Dashboard dashboard;


    public ProfileSteps(Header header, Profile profile, Dashboard dashboard) {
        this.header = header;
        this.profile = profile;
        this.dashboard = dashboard;
    }

    @When("I click the profile dropdown")
    public void iClickProfileDropdown(){
        header.clickHeaderMyAccountMenu();
    }

    @And("I click \"Your Profile\" link")
    public void iClickYourProfileLink(){
        header.clickYourProfileLink();
    }

    @Then("I validate the page title name is the same as the profile account")
    public void iValidatePageTitleAndProfileAccountIsTheSame(){
        String pageTitleAccount = profile.getPageTitleAccount();
        String profileName = header.getMyAccountName();
        assertEquals(pageTitleAccount, profileName);
    }

    @Then("I click the \"Edit\" button")
    public void iClickTheEditButton(){
        profile.clickEditButton();
    }

    @And("I go to the \"Interests & Activities\" tab")
    public void iGoToInterestsTab(){
        profile.goToInterestsTab();
    }

    @And("I add {string} as an Interest")
    public void iAddAnInterest(String interest){
        profile.addInterest(interest);
    }

    @And("I click the \"Save Changes\" button")
    public void iClickSaveChangesButton(){
        profile.clickSaveButton();
    }

    @Then("I validate {string} message appeared")
    public void iValidateMessageAppeared(String message){
        assertEquals(message, dashboard.getMessageText());
    }
}
