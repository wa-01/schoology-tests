Feature: deleteCourse

  Background:
    Given I sign in as "trainer"
    And I click Courses menu
    And I click myCourses link
    And I click createCourse button
    And I create course with:
      | course_name  | planningTest1 |
      | section_name | A             |
      | subject_area | Science       |
      | level        | 1             |
   And I validate course label is "planningTest1: Section 1A"

  Scenario: Delete course
    When I click Courses menu
    And I click myCourses link
    And I click actions for "planningTest1" course
    And I click delete for "planningTest1" course
    And I confirm delete course
    Then I validate course "planningTest1" is not listed in Courses list
    And I click Courses menu
    And I validate course "planningTest1" is not listed in Courses



