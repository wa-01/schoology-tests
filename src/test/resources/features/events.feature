Feature: Activities
  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: Create new Event from "Recent Activity"
    When I click the "Events" link
      And I set the event title as "EventTitle"
      And I select the "Post to" option to "Me"
      And I press the "Create" event button
      And I go to the "Recent Activity" page
    Then I validate event "EventTitle" is available
