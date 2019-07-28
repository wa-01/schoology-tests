Feature: Resources

  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: I can add a Folder resource
    When I click the "Resources" button
      And I click the "Add Resources" dropdown
      And I click the "Add Folder" resource button
      And I add name "FolderName" to folder
      And I click the "Create" button
    Then I validate "FolderName" folder is available


