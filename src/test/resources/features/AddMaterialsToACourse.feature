Feature: AddFolderMaterialToACourse

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

  Scenario: Add materials to course
    When I click Courses menu
    And I click "planningTest1" course
    And I click Add Materials
    And I click Add Folder
    And I create folder with:
      | folder_title  | FolderTesting1    |
      | folder_color  | orange            |
    Then I validate folder "FolderTesting1" is listed in materials list
    And I click materials context menu
    And I validate folder "FolderTesting1" is listed in materials context menu



