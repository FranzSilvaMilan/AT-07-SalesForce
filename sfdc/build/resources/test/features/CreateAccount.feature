Feature: Create Account

  Scenario: verify that is not posible create a new Account with empty name
    Given I go to "Account" Home Page
    And I click on New "Account"
    When I fill the Account form with:
      | ACCOUNT_NAME |  |
    Then "Account Name" message should be displayed in "Account" form

  Scenario: verify that is possible create a new Account with some field fill
    Given I go to "Account" Home Page
    And I click on New "Account"
    When I fill the Account form with:
      | ACCOUNT_NAME             | franz                      |
      | ACCOUNT_TYPE             | Prospect                   |
      | ACCOUNT_WEBSITE          | www.franz.com              |
      | ACCOUNT_DESCRIPTION      | This is a Description test |
      | ACCOUNT_PHONE            | 59179866                   |
      | ACCOUNT_INDUSTRY         | jalasoft                   |
      | ACCOUNT_EMPLOYEES        | 18                         |
      | ACCOUNT_STREET           | Some Street                |
      | ACCOUNT_CITY             | Cochabamba                 |
      | ACCOUNT_ZIP              | 3001                       |
      | ACCOUNT_STATE            | Cercado                    |
      | ACCOUNT_COUNTRY          | Bolivia                    |
    Then "Account "${ACCOUNT_NAME}" was created." message should be displayed in "Account" Detail Page
    And the Account should be displayed
    And I go to "Account" Home Page
    And the Account should be displayed on Home Page table
    And Assert all


