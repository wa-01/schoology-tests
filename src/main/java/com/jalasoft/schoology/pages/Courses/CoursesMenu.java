package com.jalasoft.schoology.pages.Courses;

import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursesMenu extends AbstractPage {

    @FindBy(xpath = "//h2[text()=\"Courses\"]/following-sibling::a[@href='/courses']")
    private WebElement headerMyCoursesLink;

    public static final String COURSE_NAME = "//div[contains(@class,'util-last-child-margin')]/descendant::div[contains(text(),'%s')]";

    public CoursesAction clickMyCoursesLink(){
        action.click(headerMyCoursesLink);
        return new CoursesAction();
    }

    public CourseCenterWrapper clickCourseName(String courseName) {
        action.click(By.xpath(String.format(COURSE_NAME, courseName)));
        return new CourseCenterWrapper();
    }

    public String readCourseName(String courseName) {
        String name = action.getText(By.xpath(String.format(COURSE_NAME, courseName)));
        return name;
    }
}