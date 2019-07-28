Feature: Settings

  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: I can edit my settings
    When I click the profile dropdown
      And I click "Settings" link
      And I add "MiddleName" as "Middle name"
      And I click the "Save Changes" button
    Then I validate "Your changes have been saved." message appeared