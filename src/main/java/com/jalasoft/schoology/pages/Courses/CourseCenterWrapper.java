package com.jalasoft.schoology.pages.Courses;

import com.jalasoft.schoology.core.ui.ISteps;
import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseCenterWrapper extends AbstractPage {

    @FindBy(xpath = "//div[@id='center-top']/descendant::a[contains(@href,'/course')]")
    private WebElement courseSectionName;

    @FindBy(xpath = "//span[@role='button']/child::span[@class='action-links-unfold-text  ']")
    private WebElement addMaterials;

    @FindBy(css = "a[href*='/folder/create']")
    private WebElement createFolder;

    @FindBy(css = ".materials-dropdown-arrow")
    private WebElement materialsContextMenu;

    @FindBy(xpath = "//a[text()='Notifications']")
    private WebElement notificationsButton;

    @FindBy(css = "#edit-submit")
    private WebElement saveNotificationButton;

    public static final String NOTIFICATION_OPTION = "//span[text()='%s']/preceding-sibling::input[@type='checkbox']";
    public static final String FOLDER_NAME = "//a[contains(text(),'%s')]";
    public static final String FOLDER_NAME_CONTEXT_MENU = "//a[text()='%s']";

    public String getCourseTitle() {
        String courseTitle = action.getText(courseSectionName);
        return courseTitle;
    }

    public void clickAddMaterials() {
        action.click(addMaterials);
    }

    public void clickMaterialsContextMenu() {
        action.click(materialsContextMenu);
    }

    public CreateFolder clickCreateFolder() {
        action.click(createFolder);
        return new CreateFolder();
    }

    public String readFolderName(String folderName) {
        String name = action.getText(By.xpath(String.format(FOLDER_NAME, folderName)));
        return name;
    }

    public String readFolderNameContextMenu(String folderName) {
        String name = action.getText(By.xpath(String.format(FOLDER_NAME_CONTEXT_MENU, folderName)));
        return name;
    }


    public void clickNotificationsButton(){
        action.click(notificationsButton);
    }

    public void checkNotificationOption(String notificationText){
        action.click(By.xpath(String.format(NOTIFICATION_OPTION, notificationText)));
    }

    public void saveNotification(){
        action.click(saveNotificationButton);
    }

}

