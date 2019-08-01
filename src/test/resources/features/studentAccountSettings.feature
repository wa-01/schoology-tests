Feature: Settings

  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: I can edit my settings
    Given I click the profile dropdown
    When I click "Settings" option
    And I add "MiddleName" as Middle name
    And I click the Save Changes button
    Then I validate "Your changes have been saved." message appeared

    Scenario: I can remove the value of an Account Setting
      Given I click the profile dropdown
      When I click "Settings" option
      And I clear the content of Middle name
      And I click the Save Changes button
      Then I validate "Your changes have been saved." message appeared