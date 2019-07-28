package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.Settings;
import cucumber.api.java.en.And;

public class SettingsStep {

    private Settings settings;

    public SettingsStep(Settings settings) {
        this.settings = settings;
    }

    @And("I add {string} as \"Middle name\"")
    public void iAddValueToSetting(String settingValue){
        settings.addSettingValue(settingValue);
    }
}
