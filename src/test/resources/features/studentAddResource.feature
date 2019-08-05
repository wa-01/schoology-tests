Feature: Resources

  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: I can add a Folder resource
    Given I click the Resources button
    When I click the Add Resources dropdown
    And I click the "Add Folder" resource button
    And I add name "FolderName" to folder
    And I click the Create button
    Then I validate "FolderName" folder is available

  Scenario: I can delete a Folder resource
    Given I click the Resources button
    When I click the "FolderName" resource checkbox
    And I click the resource Edit button
    And I click the resource Delete button
    And I click the Delete button to confirm
    And I wait 5 seconds to avoid Too Many Requests message

  Scenario: I can add a Folder resource
    When I click the Resources button
    And I click the Add Resources dropdown
    And I click the "Add Link" resource button
    And I add URL "http://www.google.com" link
    And I add URL "urlTitle" title
    And I click the "Add" button
    Then I validate "urlTitle" link is available

  Scenario: I can delete a Link resource
    Given I click the Resources button
    When I click the "urlTitle" resource checkbox
    And I click the resource Edit button
    And I click the resource Delete button
    And I click the Delete button to confirm
    And I wait 5 seconds to avoid Too Many Requests message
