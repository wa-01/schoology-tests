Feature: Login

  Scenario: Login as user
    Given I sign in as "marco.mendieta@jalasoft.com" user and "P@ssw0rd"
    When I click Account Menu
    Then I validate the account label is "Marco Mendieta"

