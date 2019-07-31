Feature: Profile

  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: I can load my profile
    When I click the profile dropdown
      And I click "Your Profile" option
    Then I validate the page title name is the same as the profile account
      And I validate my birthday is: "May 15"
      And I validate my email is: "ruben.mendoza.jala@gmail.com"