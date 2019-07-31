package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.core.Environment;
import com.jalasoft.schoology.pages.AccountMenu;
import com.jalasoft.schoology.pages.Header;
import com.jalasoft.schoology.pages.Signin;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.After;

public class CommonSteps {

    @Given("I sign in as {string}")
    public void iSignInAsUserAnd(String user) {
        Signin signin = new Signin();
        String userName = Environment.getInstance().getValue(String.format("$['credentials']['%s']['username']", user));
        String password = Environment.getInstance().getValue(String.format("$['credentials']['%s']['password']", user));

        signin.loginAs(userName, password);
    }

    @After()
    public void testEnd(Scenario scenario){
        Header header = new Header();
        AccountMenu accountMenu = header.clickHeaderMyAccountMenu();
        accountMenu.clickLogoutItem();
    }
}
