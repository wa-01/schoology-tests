Feature: Profile

  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: I can load my profile
    When I click the profile dropdown
      And I click 'Your Profile" link
    Then I validate the page title name is the same as the profile account