package com.jalasoft.schoology.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Signin extends AbstractPage {

    @FindBy(css = "#credentials_username")
    private WebElement userNameTextField;

    @FindBy(css = "#credentials_password")
    private WebElement passwordTextField;

    @FindBy(css = ".app_signin_action_button")
    private WebElement loginButton;

    public Signin() {
        driver.get("https://www.pivotaltracker.com/signin?source=navbar");
    }

    public void loginAs(String userName, String password) {
        action.setValue(userNameTextField, userName);
        action.click(loginButton);
        action.setValue(passwordTextField, password);
        action.click(loginButton);
    }
}
