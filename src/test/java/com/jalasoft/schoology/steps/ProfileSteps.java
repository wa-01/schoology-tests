package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.Dashboard;
import com.jalasoft.schoology.pages.Header;
import com.jalasoft.schoology.pages.Profile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class ProfileSteps {

    private Header header;
    private Profile profile;
    private Dashboard dasboard;

    @Given("I click the profile dropdown")
    public void iClickProfileDropdown(){
        header = new Header();
        header.clickHeaderMyAccountMenu();
    }

    @When("I click {string} option")
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
        profile = new Profile();
        String birthdayText = profile.getBirthdayText();
        assertEquals(birthday, birthdayText);
    }

    @And("I validate my email is: {string}")
    public void iValidateMyEmail(String email){
        profile = new Profile();
        String emailText = profile.getEmailText();
        assertEquals(email, emailText);
    }

    @And("I click the Edit button")
    public void iClickTheEditButton(){
        profile = new Profile();
        profile.clickEditButton();
    }

    @And("I go to the Interests & Activities tab")
    public void iGoToInterestsTab(){
        profile = new Profile();
        profile.goToInterestsTab();
    }

    @And("I add {string} as an Interest")
    public void iAddAnInterest(String interest){
        profile = new Profile();
        profile.addInterest(interest);
    }

    @And("I click the Save Changes button")
    public void iClickSaveChangesButton(){
        profile = new Profile();
        profile.clickSaveButton();
    }

    @Then("I validate {string} message appeared")
    public void iValidateMessageAppeared(String message){
        Dashboard dashboard = new Dashboard();
        assertEquals(message, dashboard.getMessageText());
    }

    @And("I clear the Interests")
    public void iClearTheInterests(){
        profile = new Profile();
        profile.clearField();
    }

    @And("I validate {string} was added as interests")
    public void iValidateInterestWasAdded(String interest){
        assertEquals(interest, profile.getInterest());
    }
}
