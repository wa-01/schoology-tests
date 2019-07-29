package com.jalasoft.schoology.pages.Courses;

import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursesList extends AbstractPage {

    public static final String COURSE_NAME = "//div[@class='sections-list']/parent::li[contains(@class,'course-item')]/descendant::span[text()='%s']";
    public static final String COURSE_ACTIONS =  "//span[text()='%s']/ancestor::li[contains(@class, 'course-item')]/descendant::span[@class='action-links-unfold-text  ']";
    public static final String COURSE_DELETE =  "//span[text()='%s']/ancestor::li[contains(@class, 'course-item')]/descendant::a[text()='Delete']";
    public static final String COURSE_EDIT =  "//span[text()='%s']/ancestor::li[contains(@class, 'course-item')]/descendant::a[text()='Edit']";

    @FindBy (css = "input[id='edit-submit']")
    private WebElement deleteConfirmation;

    public void clickCourseName(String courseName) {
        action.click(By.xpath(String.format(COURSE_NAME, courseName)));
    }

    public void clickCourseActions(String courseName) {
        action.click(By.xpath(String.format(COURSE_ACTIONS, courseName)));
    }

    public void clickDeleteCourse(String courseName) {
        action.click(By.xpath(String.format(COURSE_DELETE, courseName)));
    }

    public void clickDeleteConfirmation(){
        action.click(deleteConfirmation);
    }

    public void clickEditCourse(String courseName) {
        action.click(By.xpath(String.format(COURSE_EDIT, courseName)));
    }
}