package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.core.Environment;
import com.jalasoft.schoology.pages.Signin;
import cucumber.api.java.en.Given;

public class CommonSteps {

    @Given("I sign in as {string}")
    public void iSignInAsUserAnd(String user) {
        Signin signin = new Signin();
        String userName = Environment.getInstance().getValue(String.format("$['credentials']['%s']['username']", user));
        String password = Environment.getInstance().getValue(String.format("$['credentials']['%s']['password']", user));

        signin.loginAs(userName, password);
    }
}
