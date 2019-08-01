Feature: Events

  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: Create new Event from "Recent Activity" page
    Given I click the Events link
    And I set the event title as "EventTitle"
    And I select the Post to option to "Me"
    And I press the Create event button
    And I go to the Recent Activity page
    Then I validate event "EventTitle" is available
    And I wait 5 seconds to avoid Too Many Requests message

  Scenario: Create new Event from Calendar
    Given I click the Calendar link
    When I start the creation of an event in Today's date
    And I set the event title as "CalendarEvent"
    And I press the Create event button
    And I go to the Home page
    Then I validate event "CalendarEvent" is available
    And I wait 5 seconds to avoid Too Many Requests message

  Scenario: I can open my created events
    Given I select event "EventTitle"
    When I validate the Created By name is the same as the profile account
    Then I validate the page title is "EventTitle"
    And I wait 5 seconds to avoid Too Many Requests message

  Scenario: I delete created events
    Given I select event "EventTitle"
    And I click the event settings button
    And I select the "Delete" option
    And I press the Delete button
    And I wait 7 seconds to avoid Too Many Requests message
    And I go to the Home page
    And I select event "CalendarEvent"
    And I click the event settings button
    And I select the "Delete" option
    And I press the Delete button
    And I wait 5 seconds to avoid Too Many Requests message