package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.Courses.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class CoursesSteps {

    private CoursesAction coursesAction;
    private CourseCreatePopup courseCreatePopup;
    private CoursesList courseList;
    private CourseCenterWrapper courseCenterWrapper;
    private CreateFolder createFolder;

    @And("I click myCourses link")
    public void iClickMyCoursesLink() {
        CoursesMenu coursesMenu= new CoursesMenu();
        coursesAction = coursesMenu.clickMyCoursesLink();
    }
    @And("I click createCourse button")
    public void iClickCreateCourseButton() {
        CoursesAction coursesAction= new CoursesAction();
        courseCreatePopup = coursesAction.clickCreateCourse();
    }
    @And("I create course with:")
    public void iCreateCourseWith(Map<String, String> data) {
        courseCreatePopup.createCourse(data);
    }

    @Then("I validate course label is {string}")
    public void iValidateTheCourseName(String courseNameSection){
        CourseCenterWrapper courseWrapper = new CourseCenterWrapper();
        assertEquals(courseNameSection, courseWrapper.getCourseTitle());
    }
    @And("I validate course {string} is listed in Courses")
    public void iValidateNewCourseIsListedInCourses(String courseName){
        CoursesMenu menu = new CoursesMenu();
        boolean courseIsListed = false;
        try {
            menu.readCourseName(courseName);
            courseIsListed = true;

        }catch (WebDriverException ex) {

        }
        Assert.assertTrue(courseIsListed);
    }

    @And ("I validate course {string} is listed in Courses list")
    public void iValidateNewCourseIsListedInCoursesList(String courseName){
        courseList = new CoursesList();
        boolean courseIsListed = false;
        try {
            courseList.clickCourseName(courseName);
            courseIsListed = true;
        } catch (WebDriverException ex) {}
        Assert.assertTrue(courseIsListed);
    }

    @And ("I click actions for {string} course")
    public void iClickCourseActions(String courseName) {
        courseList = new CoursesList();
        courseList.clickCourseActions(courseName);
    }
    @And ("I click delete for {string} course")
    public void iClickDeleteCourse(String courseName) {
        courseList = new CoursesList();
        courseList.clickDeleteCourse(courseName);
    }
    @And ("I confirm delete course")
    public void iConfirmDeleteCourse() {
        courseList = new CoursesList();
        courseList.clickDeleteConfirmation();
    }
    @Then ("I validate course {string} is not listed in Courses list")
    public void iValidateCourseIsNotListedInCourseList(String courseName) {
        CoursesMenu menu = new CoursesMenu();
        boolean courseIsListed = true;
        try {
            menu.clickCourseName(courseName);
        }catch (WebDriverException ex) {
            courseIsListed = false;
        }
        Assert.assertFalse(courseIsListed);
    }
    @And("I validate course {string} is not listed in Courses")
    public void iValidateNewCourseIsNotListedInCourses(String courseName){
        CoursesMenu menu = new CoursesMenu();
        boolean courseIsListed = true;
        try {
            menu.readCourseName(courseName);;
        }catch (WebDriverException ex) {
            courseIsListed = false;
        }
        Assert.assertFalse(courseIsListed);
    }
    @And ("I click edit for {string} course")
    public void iClickEditCourse(String courseName) {
        courseList = new CoursesList();
        courseList.clickEditCourse(courseName);
    }
    @And ("I change subject area value with {string}")
    public void iChangeSubjectArea(String subjectArea) {
        courseCreatePopup.selectLevel(subjectArea);
        courseCreatePopup.saveCourse();
    }
    @Then ("I validate subject area value is {string}")
    public void iValidateSubjectAreaValue(String subjectArea) {
        String actualSubjectArea = courseCreatePopup.getSubjectArea();
        assertEquals(actualSubjectArea, subjectArea);
    }
    @And ("I click {string} course")
    public void iClickCourseName(String courseName) {
        CoursesMenu coursesMenu = new CoursesMenu();
        coursesMenu.clickCourseName(courseName);
    }
    @And ("I click Add Materials")
    public void iClickAddMaterials(){
        courseCenterWrapper = new CourseCenterWrapper();
        courseCenterWrapper.clickAddMaterials();
    }
    @And ("I click Add Folder")
    public void iClickAddFolder(){
        courseCenterWrapper = new CourseCenterWrapper();
        courseCenterWrapper.clickCreateFolder();
    }
    @And ("I create folder with:")
    public void iSetFolderName(Map<String, String> folderData){
        createFolder = new CreateFolder();
        createFolder.createFolder(folderData);
    }
}