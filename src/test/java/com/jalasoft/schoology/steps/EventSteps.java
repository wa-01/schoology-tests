package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.Dashboard;
import com.jalasoft.schoology.pages.Header;
import com.jalasoft.schoology.pages.event.EventDetails;
import com.jalasoft.schoology.pages.event.EventForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class EventSteps {

    private Dashboard dashboard;
    private EventDetails eventDetails;
    private EventForm eventForm;
    private Header header;

    public EventSteps(Dashboard dashboard, EventDetails eventDetails, EventForm eventForm, Header header) {
        this.dashboard = dashboard;
        this.eventDetails = eventDetails;
        this.eventForm = eventForm;
        this.header = header;
    }
    @Given("I click the Events link")
    public void iClickTheEventsLink(){
        dashboard.clickTheEventLink();
    }
    @And("I set the event title as {string}")
    public void iSetEventTitle(String title){
        eventDetails = eventForm.setEventTitle(title);
    }
    @And("I select the Post to option to {string}")
    public void iSelectPostTo(String profile){
        eventDetails = eventForm.setEventPostTo(profile);
    }
    @And("I press the Create event button")
    public void iPressCreateEventButton(){
        eventDetails = eventForm.pressButton();
    }
    @And("I go to the Recent Activity page")
    public void iGoToRecentActivityPage(){
        eventDetails.goToRecentActivityPage();
    }
    @Then("I validate event {string} is available")
    public void iValidateEventIsAvailable(String eventTitle){
        String actualEventTitle = eventDetails.getEventTitleLabel();
        assertEquals(actualEventTitle, eventTitle);
    }
    @And("I wait {int} seconds to avoid Too Many Requests message")
    public void iWaitSomeSeconds(int seconds) throws InterruptedException {
        eventDetails.waitSomeSeconds(seconds);
    }
    @Given("I click the Calendar link")
    public void iClickTheCalendarLink(){
        dashboard.clickTheCalendarLink();
    }
    @When("I start the creation of an event in Today's date")
    public void iStartTheCreationOfEventToday(){
        eventDetails.startCreatingEventToday();
    }
    @And("I go to the Home page")
    public void iGoToTheHomePage(){
        eventDetails.goToHomePage();
    }
    @Given("I select event {string}")
    public void iSelectAnEvent(String eventTitle){
        eventDetails.selectEvent(eventTitle);
    }
    @When("I validate the Created By name is the same as the profile account")
    public void iValidateCreatedByAndProfileNameIsTheSame(){
        String createdByName = eventDetails.getCreatedByName();
        String profileName = header.getMyAccountName();
        assertEquals(createdByName, profileName);
    }
    @Then("I validate the page title is {string}")
    public void iValidatePageTitleIsEventName(String eventName){
        String pageTitle = dashboard.getPageTitle();
        assertEquals(eventName, pageTitle);
    }
    @And("I click the event settings button")
    public void iClickTheEventSettingsButton(){
        dashboard.clickEventSettingsButton();
    }
    @And("I select the {string} option")
    public void iSelectSettingOption(String option){
        dashboard.selectSettingOption(option);
    }
    @And("I press the Delete button")
    public void iPressTheDeleteButton(){
        dashboard.pressDeleteButton();
    }
}
