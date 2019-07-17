package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.AccountMenu;
import com.jalasoft.schoology.pages.Header;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class HeaderSteps {

    private AccountMenu accountMenu;

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
}
