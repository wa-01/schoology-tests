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

    public EventSteps(Dashboard dashboard, EventDetails eventDetails, EventForm eventForm) {
        this.dashboard = dashboard;
        this.eventDetails = eventDetails;
        this.eventForm = eventForm;
    }

    @And("I click the Events link")
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


}
