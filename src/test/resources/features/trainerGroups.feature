Feature: Groups

  Background: Login as trainer
    Given I sign in as "trainer"

  Scenario: Add new Group
    When I click Group Tab
    And I add Group With:
      | edit-name        | Test Group             |
      | edit-description | Test Group Description |
      | privacy_level    | school                 |
      | invite_type      | 0                      |
      | category         | abroad                 |
    Then I validate group title is "Test Group"
    And I validate group information "Test Group Description"
    And I validate group Category "Abroad/Overseas Groups"

  Scenario: Update new Group
    When I click Group Tab
    And I add Group With:
      | edit-name        | Test Group             |
      | edit-description | Test Group Description |
      | privacy_level    | school                 |
      | invite_type      | 0                      |
      | category         | abroad                 |
    And I edit group info with:
      | edit-name        | Test Group updated   |
      | edit-description | Description updated  |
      | privacy_level    | group                |
      | invite_type      | 2                    |
      | category         | advising             |
    And I click back to Group link
    Then I validate group title is "Test Group updated"
    And I validate group information "Description updated"
    And I validate group Category "Advising Groups"