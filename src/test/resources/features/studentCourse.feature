Feature: Courses

  Background: Sign-in in Schoology
    Given I sign in as "student"

  Scenario: I can open my course
    Given I select Course Dashboard
    When I select course "WA-01: Section 1"
    Then I validate the page title is "WA-01: Section 1"