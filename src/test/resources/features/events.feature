Feature: Activities
  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: Create new Event
    When I click the "Events" link
      And I create the event with:
        | title | EventTitle |
        | postTo | Me



