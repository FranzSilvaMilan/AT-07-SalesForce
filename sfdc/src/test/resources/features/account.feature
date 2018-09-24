Feature: Create Account

  Background:
    Given I navigate to Login page
    And I login as "franz" User



  @editAccount @deleteAccountAfter
  Scenario: Verify that is posible edit Account
    Given I have Account with following information:
      | name      | number | web           | phone | sicCode | fax   | employees |
      | franzEdit | 98     | www.franz.com | 6666  | 7854785 | 11111 | 8         |
    And I go to Account Home Page
    When I select the Account on list account page
    And I edit the Account with the following information:
      | name    | number | web          |
      | franzSS | 88     | www.jala.com |
    Then I should the Account updated







