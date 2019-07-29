package com.jalasoft.schoology.pages.Courses;

import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseCenterWrapper extends AbstractPage {

    @FindBy(xpath = "//div[@id='center-top']/descendant::a[contains(@href,'/course')]")
    private WebElement courseSectionName;

    @FindBy(xpath = "//span[@role='button']/child::span[@class='action-links-unfold-text  ']")
    private WebElement addMaterials;

    @FindBy(css = "a[href*='/folder/create']")
    private WebElement createFolder;

    public String getCourseTitle(){
        String courseTitle = action.getText(courseSectionName);
        return courseTitle;
    }

    public void clickAddMaterials(){
        action.click(addMaterials);
    }

    public CreateFolder clickCreateFolder(){
        action.click(createFolder);
        return new CreateFolder();
    }

}
