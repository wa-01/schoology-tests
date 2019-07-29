package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.AccountMenu;
import com.jalasoft.schoology.pages.Courses.CoursesMenu;
import com.jalasoft.schoology.pages.Header;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class HeaderSteps {

    private AccountMenu accountMenu;
    private CoursesMenu coursesMenu;

    @Given("I validate the account label is {string}")
    public void iAssertAccountName(String userName) {
        Header header = new Header();
        Assert.assertEquals(userName ,header.getMyAccountName());
    }

    @Then("I click Account Menu")
    public void iClickAccountMenu(){
        Header header = new Header();
        accountMenu = header.clickHeaderMyAccountMenu();
    }

    @When("I click Courses menu")
    public void iClickCoursesMenu(){
        Header header = new Header();
        coursesMenu = header.clickHeaderCoursesMenu();
    }
}
