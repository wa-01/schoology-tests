Feature: createCourse

  Background:
    Given I sign in as "trainer"

  Scenario: Create course
    When I click Courses menu
    And I click myCourses link
    And I click createCourse button
    And I create course with:
    | course_name  | planningTest1 |
    | section_name | A             |
    | subject_area | Science       |
    | level        | 1      |

    Then I validate course label is "planningTest1: Section 1A"
    And I click Courses menu
    And I validate course "planningTest1" is listed in Courses
    And I click myCourses link
    And I validate course "planningTest1" is listed in Courses list



