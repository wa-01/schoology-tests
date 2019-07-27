package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.AbstractPage;
import com.jalasoft.schoology.pages.Dashboard;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventsStep extends AbstractPage {

    private Dashboard dashboard;

    public EventsStep(Dashboard dashboard){
        this.dashboard = dashboard;
    }

    @When("I click the \"Events\" link")
    public void iClickTheEventsLink(){
        dashboard.clickTheEventLink();
    }

}
