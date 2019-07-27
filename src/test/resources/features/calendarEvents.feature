Feature: Activities
  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: Create new Event from Calendar
    When I click the "Calendar" link
      And I start the creation of an event in Today's date
      And I set the event title as "CalendarEvent"
      And I press the "Create" event button
      And I go to the "Home" page
    Then I validate event "CalendarEvent" is available