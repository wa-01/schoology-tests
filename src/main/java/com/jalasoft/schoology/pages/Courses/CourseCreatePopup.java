package com.jalasoft.schoology.pages.Courses;

import com.jalasoft.schoology.core.ui.ISteps;
import com.jalasoft.schoology.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CourseCreatePopup extends AbstractPage {

    @FindBy(css = "input[name=\"course_name\"]")
    private WebElement courseName;

    @FindBy(css = "input[name=\"section_name-1\"]")
    private WebElement sectionName;

    @FindBy(xpath = "//select[contains(@class, 'subject-area')]")
    private WebElement subjectAreaDropdown;

    @FindBy(xpath = "//select[contains(@class, 'subject-area')]/child::option[@selected='selected']")
    private WebElement subjectAreaSelected;

    @FindBy(xpath = "//select[contains(@class, 'range-start')]")
    private WebElement levelDropdown;

    @FindBy(css = "input[class='form-submit']")
    private WebElement saveCourse;

    @FindBy(css = "a[href=\"javascript://\"]")
    private WebElement closeCreateCourseWindow;

    public static final String SUBJECT_AREA = "//option[contains(text(),'%s')]";
    public static final String LEVEL = "//option[contains(text(),'%s')]";

    public CourseCenterWrapper createCourse(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("course_name", () -> action.setValue(courseName, data.get("course_name")));
        strategyMap.put("section_name", () -> action.setValue(sectionName, data.get("section_name")));
        strategyMap.put("subject_area", () -> selectSubjectArea(data.get("subject_area")));
        strategyMap.put("level", () -> selectLevel(data.get("level")));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }

        action.click(saveCourse);
        return new CourseCenterWrapper();
    }

    private void clickSubjectAreaDropdown() {
        action.click(subjectAreaDropdown);
    }

    private void selectSubjectArea(String subjectArea) {
        clickSubjectAreaDropdown();
        action.click(By.xpath(String.format(SUBJECT_AREA, subjectArea)));
    }

    public void selectLevel(String level) {
        action.click(levelDropdown);
        action.click(By.xpath(String.format(LEVEL, level)));
    }
    public void saveCourse() {
        action.click(saveCourse);
        driver.navigate().refresh();
    }
    public String getSubjectArea(){
        String subjectArea = action.getText(subjectAreaSelected);
        return subjectArea;
    }

    public void closeCreateWindow(){
        action.click(closeCreateCourseWindow);
    }
}