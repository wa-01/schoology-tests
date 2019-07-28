package com.jalasoft.schoology.steps;

import com.jalasoft.schoology.pages.AbstractPage;
import com.jalasoft.schoology.pages.Course;
import com.jalasoft.schoology.pages.Dashboard;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class CoursesSteps extends AbstractPage {

    private Dashboard dashboard;
    private Course course;

    public CoursesSteps(Dashboard dashboard, Course course) {
        this.dashboard = dashboard;
        this.course = course;
    }

    public CoursesSteps(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    @When("I select \"Course Dashboard\"")
    public void iSelectCourseDashboard(){
        dashboard.clickCourseDashboardTab();
    }

    @And("I select course {string}")
    public void iSelectACourse(String courseName){
        course.selectCourse(courseName);
    }

    @Then("I validate the page title is {string}")
    public void iValidateCoursePAgeTitle(String courseName){
        String actualCourseName = course.getCourseName();
        assertEquals(actualCourseName, courseName);
    }
}
