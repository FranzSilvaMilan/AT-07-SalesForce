@AccountApi
Feature: Create Account API

  Background:
    Given I navigate to Login page
    And I login as "franz" User

  @createAccount @deleteAccountAfter
  Scenario: Verify that is posible create Account
    Given I go to Account Home Page
    And I click on New Account
    When I fill the Account form with:
      | name      | silvaMap      |
      | number    | 100           |
      | phone     | 6072452       |
      | fax       | 000000        |
      | web       | www.franz.com |
      | employees | 10            |
    Then "silvaMap" name should be displayed in detail Page Account

  @editAccount @deleteAccountAfter
  Scenario: Verify that is posible delet Account
    Given I have Account with following information:
      | name      | number | web           | phone | sicCode | fax   | employees |
      | franzEdit | 98     | www.franz.com | 6666  | 7854785 | 11111 | 8         |
    And I go to Account Home Page
    When I select the Account on list account page
    And I delete the Account
    Then I should see the Account is removed from the Accounts list page

  @editAccount @deleteAccountAfter
  Scenario: Verify that is posible edit Account
    Given I have Account with following information:
      | name      | number | web           | phone | sicCode | fax   | employees |
      | franzEdit | 98     | www.franz.com | 6666  | 7854785 | 11111 | 8         |
    And I go to Account Home Page
    When I select the Account on list account page
    And I click on Edit Button
    And I edit the Account with the following information:
      | name    | number | web          |
      | franzSS | 88     | www.jala.com |
    Then I should see the Account updated in the Accounts page
    And I should the Account updated