package com.jalasoft.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Course extends AbstractPage {

    private static final String COURSE_NAME = "//div[contains(text(),'%s')]";

    @FindBy(css = ".page-title ")
    private WebElement courseName;

    public void selectCourse(String courseName){
        String courseLocator = String.format(COURSE_NAME, courseName);
        action.click(By.xpath(courseLocator));
    }

    public String getCourseName(){
        return action.getText(courseName);
    }
}
