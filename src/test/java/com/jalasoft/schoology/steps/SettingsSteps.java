package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.Settings;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.testng.Assert.assertEquals;

public class SettingsSteps {

    private Settings settings;

    public SettingsSteps(Settings settings) {
        this.settings = settings;
    }

    @And("I add {string} as Middle name")
    public void iAddValueToSetting(String settingValue){
        settings.addSettingValue(settingValue);
    }

    @Then("I clear the content of Middle name")
    public void iClearContentOfMiddleNameSetting(){
        settings.clearSettingContent();
    }
}
