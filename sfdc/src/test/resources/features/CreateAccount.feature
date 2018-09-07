Feature: Create Account
 Background:
   Given I navigate to Login page
   And I login as "franz" User
  Scenario: verify that is not posible create a new Account with empty name
    Given I go to "Account" Home Page
    And I click on New "Account"
    When I fill the Account form name with : "franz"
    #When I fill the Account form with:
    #  | ACCOUNT_NAME | franz |
    #Then "Account Name" message should be displayed in "Account" form




