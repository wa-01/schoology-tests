Feature: Login

  Scenario: Login as user
    Given I sign in as "trainer"
    Then I validate the account label is "Emely LLanos"