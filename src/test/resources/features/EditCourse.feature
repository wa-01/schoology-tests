Feature: EditCourse

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

  Scenario: Edit SubjectArea
    When I click Courses menu
    And I click myCourses link
    And I click actions for "planningTest1" course
    And I click edit for "planningTest1" course
    And I change subject area value with "Technology"
    And I click actions for "planningTest1" course
    And I click edit for "planningTest1" course
    Then I validate subject area value is "Technology"
    And I close edit course window





