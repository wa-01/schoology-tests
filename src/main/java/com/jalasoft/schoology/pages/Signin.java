package com.jalasoft.schoology.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Signin extends AbstractPage {

    @FindBy(css = "#edit-mail")
    private WebElement userNameTextField;

    @FindBy(css = "#edit-pass")
    private WebElement passwordTextField;

    @FindBy(css = "#edit-submit")
    private WebElement loginButton;

    public Signin() {
        driver.get("https://app.schoology.com/login");
    }

    public Header loginAs(String userName, String password) {
        action.setValue(userNameTextField, userName);
        action.click(loginButton);
        action.setValue(passwordTextField, password);
        action.click(loginButton);
        return new Header();
    }
}
