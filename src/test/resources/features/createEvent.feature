Feature: Events

  Scenario: Create new Event from "Recent Activity" page
    Given I sign in as "student"
    When I click the "Events" link
      And I set the event title as "EventTitle"
      And I select the "Post to" option to "Me"
      And I press the "Create" event button
      And I go to the "Recent Activity" page
    Then I validate event "EventTitle" is available
      And I wait 5 seconds to avoid "Too Many Requests" message

  Scenario: Create new Event from Calendar
    Given I click the "Calendar" link
      When I start the creation of an event in Today's date
        And I set the event title as "CalendarEvent"
        And I press the "Create" event button
        And I go to the "Home" page
    Then I validate event "CalendarEvent" is available
      And I wait 5 seconds to avoid "Too Many Requests" message