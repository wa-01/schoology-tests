Feature: Login

  Scenario: Login as user
    Given I sign in as "trainer"
    When I click Account Menu
    Then I validate the account label is "marco mendieta"