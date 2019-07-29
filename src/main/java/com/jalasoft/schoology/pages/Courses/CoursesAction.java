package com.jalasoft.schoology.pages.Courses;

import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursesAction extends AbstractPage {

    @FindBy(xpath = "//a[text()=\"Create Course\"]")
    private WebElement createCourse;

    public CourseCreatePopup clickCreateCourse(){
        action.click(createCourse);
        return new CourseCreatePopup();
    }
}