package com.jalasoft.schoology.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountMenu extends AbstractPage{

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutMenu;

    public Signin clickLogoutItem() {
        action.click(logoutMenu);
        return new Signin();
    }
}
