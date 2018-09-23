Feature: Create Account

  Background:
    Given I navigate to Login page
    And I login as "franz" User

  @createAccount
  Scenario: Verify that is posible create Account
    Given I go to Account Home Page
    And I click on New Account
    When I fill the Account form with:
      | ACCOUNT_NAME   | silva         |
      | ACCOUNT_NUMBER | 100           |
      | ACCOUNT_SITE   | 2             |
      | ANNUAL_REVENUE | 100           |
      | RATING         | Hot           |
      | PHONE          | 6072452       |
      | FAX            | 000000        |
      | WEBSITE        | www.franz.com |
      | TICKER_SYMBOL  | ACC           |
      | EMPLOYEES      | 10            |
        #| SIC_CODE       | 111223        |
    Then "silva" name should be displayed in detail Page Account

  @editAccount
  Scenario: Verify that is posible edit Account
    Given I go to Account Home Page
    And I have new Account with following information:
      | name       | number | web           | phone | sicCode | fax   | employees |
      | franzSilva | 98     | www.franz.com | 6666  | 7854785 | 11111 | 8         |
    When I select the Account
    And I edit that Account with the following information:
      | name    | number | web          |
      | franzSS | 88     | www.jala.com |
    Then I should see the Account updated in the Accounts page "franzSS"

  @deletAccount
  Scenario: Verify that is posible delet Account
    Given I go to Account Home Page
    And I have new Account with following information:
      | name       | number | web           | phone | sicCode | fax   | employees |
      | franzSilva | 98     | www.franz.com | 6666  | 7854785 | 11111 | 8         |
    And I delete the Account
    Then I should see the Account is removed from the Accounts list page









