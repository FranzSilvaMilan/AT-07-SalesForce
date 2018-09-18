Feature: Create Account

  Background:
    Given I navigate to Login page
    And I login as "franz" User


  Scenario: Verify that is posible edit Account
    Given I go to Account Home Page
    And I have new Account with following information:
      | name       | number | web           | phone | sicCode | fax   | employees |
      | franzSilva | 98     | www.franz.com | 6666  | 7854785 | 11111 | 8         |
    When I select the Account
    And I edit that Account with the following information:
      | name   | number | web          |
      | franzSS | 88     | www.jala.com |
    Then I should see the Account updated in the Accounts page "franzSS"





