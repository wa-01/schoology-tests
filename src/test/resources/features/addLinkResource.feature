Feature: Resources

  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: I can add a Folder resource
    When I click the "Resources" button
    And I click the "Add Resources" dropdown
    And I click the "Add Link" resource button
    And I add URL "http://www.google.com" link
    And I add URL "urlTitle" title
    And I click the "Add" button
    Then I validate "urlTitle" link is available