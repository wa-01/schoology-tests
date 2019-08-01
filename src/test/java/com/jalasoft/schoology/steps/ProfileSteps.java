package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.Header;
import com.jalasoft.schoology.pages.Profile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class ProfileSteps {

    private Header header;
    private Profile profile;

    @When("I click the profile dropdown")
    public void iClickProfileDropdown(){
        header = new Header();
        header.clickHeaderMyAccountMenu();
    }
    @And("I click {string} option")
    public void iClickYourProfileLink(String link){
        header.clickAccountLink(link);
    }
    @Then("I validate the page title name is the same as the profile account")
    public void iValidatePageTitleAndProfileAccountIsTheSame(){
        profile = new Profile();
        String pageTitleAccount = profile.getPageTitleAccount();
        String profileName = header.getMyAccountName();
        assertEquals(pageTitleAccount, profileName);
    }
    @And("I validate my birthday is: {string}")
    public void iValidateMyBirthday(String birthday){
        String birthdayText = profile.getBirthdayText();
        assertEquals(birthday, birthdayText);
    }
    @And("I validate my email is: {string}")
    public void iValidateMyEmail(String email){
        String emailText = profile.getEmailText();
        assertEquals(email, emailText);
    }
}
