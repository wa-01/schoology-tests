Feature: Profile

  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: I can load my profile
    Given I click the profile dropdown
    When I click "Your Profile" option
    Then I validate the page title name is the same as the profile account
    And I validate my birthday is: "May 15"
    And I validate my email is: "ruben.mendoza.jala@gmail.com"

  Scenario: I can edit my profile adding an Interest
    Given I click the profile dropdown
    And I click "Your Profile" option
    And I click the Edit button
    And I go to the Interests & Activities tab
    And I add "movies" as an Interest
    And I click the Save Changes button
    Then I validate "Your profile has been updated." message appeared
    And I click the profile dropdown
    And I click "Your Profile" option
    And I validate "movies" was added as interests


    Scenario: I can edit my profile removing an Interest
      Given I click the profile dropdown
      And I click "Your Profile" option
      And I click the Edit button
      And I go to the Interests & Activities tab
      And I clear the Interests
      And I click the Save Changes button
      Then I validate "Your profile has been updated." message appeared