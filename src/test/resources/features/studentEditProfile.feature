Feature: Profile

  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: I can edit my profile
    When I click the profile dropdown
      And I click "Your Profile" link
      And I click the "Edit" button
      And I go to the "Interests & Activities" tab
      And I add "movies" as an Interest
      And I click the "Save Changes" button
    Then I validate "Your profile has been updated." message appeared
