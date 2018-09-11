Feature: Create Account
 Background:
   Given I navigate to Login page
   And I login as "franz" User
  Scenario: verify that is posible create a new Account with field required
    Given I go to Account Home Page
    And I click on New Account
    When I fill the Account form name with : "franz"
    Then "franz" name should be displayed in detail Page Account




