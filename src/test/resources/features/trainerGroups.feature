Feature: Groups

  Background: Login as trainer
    Given I sign in as "trainer"

  Scenario: Add new Group
    When I click Group Tab
    And I add Group With:
      | edit-name        | Test Group             |
      | edit-description | Test Group Description |