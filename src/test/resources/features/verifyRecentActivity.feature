
Feature: Activities
  Background: Sign-in in Schoology
    Given I sign in as "student"
      And I click the "Events" link
      And I set the event title as "VerifyEvent"
      And I select the "Post to" option to "Me"
      And I press the "Create" event button
      And I go to the "Recent Activity" page

  Scenario: I can open my created events
    When I select event "VerifyEvent"
    Then I validate the "Created By" name is the same as the profile account
