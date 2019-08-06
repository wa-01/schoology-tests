package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.Courses.*;
import com.jalasoft.schoology.pages.Dashboard;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
    private Dashboard dashboard;

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

    @Given("I select Course Dashboard")
    public void iSelectCourseDashboard(){
        dashboard = new Dashboard();
        dashboard.clickCourseDashboardTab();
    }

    @When("I select course {string}")
    public void iSelectACourse(String courseName){
        dashboard.selectCourse(courseName);
    }

    @Then ("I validate folder {string} is listed in materials list")
    public void iValidateFolderIsListedInMaterialsList(String folder){
        courseCenterWrapper = new CourseCenterWrapper();
        boolean folderIsListed = false;
        try {
            courseCenterWrapper.readFolderName(folder);
            folderIsListed = true;
        } catch (WebDriverException ex) {}
        Assert.assertFalse(folderIsListed);
    }

    @And ("I click materials context menu")
    public void iSetFolderName(){
        courseCenterWrapper = new CourseCenterWrapper();
        courseCenterWrapper.clickMaterialsContextMenu();
    }

    @And ("I validate folder {string} is listed in materials context menu")
    public void iValidateFolderIsListedInMaterialsContextMenu(String folder){
        courseCenterWrapper = new CourseCenterWrapper();
        boolean folderIsListed = false;
        try {
            courseCenterWrapper.readFolderNameContextMenu(folder);
            folderIsListed = true;
        } catch (WebDriverException ex) {}
        Assert.assertTrue(folderIsListed);
    }

    @When("I click Notifications button")
    public void iClickNotificationsButton(){
        courseCenterWrapper = new CourseCenterWrapper();
        courseCenterWrapper.clickNotificationsButton();
    }

    @ And ("I check {string} option")
    public void iSelectNotifications(String notificationOption){
        courseCenterWrapper = new CourseCenterWrapper();
        courseCenterWrapper.checkNotificationOption(notificationOption);
    }

    @And ("I click save notification changes button")
    public void iSaveNotificationChanges(){
        courseCenterWrapper = new CourseCenterWrapper();
        courseCenterWrapper.saveNotification();
    }

    @And ("I close edit course window")
    public void icloseCreateCourseWindow(){
        courseCreatePopup.closeCreateWindow();
    }

    @Then ("I validate {string} notification is selected")
    public void iValidateNotificationIsSelected(String notification){
        courseCenterWrapper = new CourseCenterWrapper();
        boolean isNotificationSelected = false;
        isNotificationSelected = courseCenterWrapper.notificationStatus(notification);
        Assert.assertTrue(isNotificationSelected);
    }
}