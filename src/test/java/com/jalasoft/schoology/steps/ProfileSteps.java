package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.AbstractPage;
import com.jalasoft.schoology.pages.Header;
import com.jalasoft.schoology.pages.Profile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class ProfileSteps extends AbstractPage {

    private Header header;
    private Profile profile;


    public ProfileSteps(Header header, Profile profile) {
        this.header = header;
        this.profile = profile;
    }

    @When("I click the profile dropdown")
    public void iClickProfileDropdown(){
        header.clickHeaderMyAccountMenu();
    }

    @And("I click \'Your Profile\" link")
    public void iClickYourProfileLink(){
        header.clickYourProfileLink();
    }

    @Then("I validate the page title name is the same as the profile account")
    public void iValidatePageTitleAndProfileAccountIsTheSame(){
        String pageTitleAccount = profile.getPageTitleAccount();
        String profileName = header.getMyAccountName();
        assertEquals(pageTitleAccount, profileName);
    }
}
