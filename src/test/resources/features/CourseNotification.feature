Feature: CourseNotification

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

  Scenario: Add notifications to a course
    When I click Notifications button
    And I check "Comments on my posts" option
    And I check "Course content created" option
    And I click save notification changes button
    And I click Notifications button
    Then I validate "Comments on my posts" notification is selected
    And I validate "Course content created" notification is selected



