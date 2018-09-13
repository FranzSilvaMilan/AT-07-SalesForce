Feature: Create Account

  Background:
    Given I navigate to Login page
    And I login as "franz" User

  Scenario: verify that is posible create a new Account with field required
    Given I go to Account Home Page
    And I click on New Account
    When I fill the Account form with:
      | ACCOUNT_NAME   | franz silva   |
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
    Then "franz silva" name should be displayed in detail Page Account




