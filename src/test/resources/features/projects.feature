Feature: Projects

  Scenario: Create Project
    Given I sign in as "Marcosis6ster" user and "P@ssw0rd"
    When I click the new project button
    And I set the project form
      | name    | MyProject24 |
      | account | Untitled     |
      | privacy | public      |
    Then I validate the project label is "MyProject24"



#    And I set the project form
#      | name        | account  | privacy |
#      | MyProject22 | account1 | public  |
#      | MyProject23 | account2 | private  |
