Feature: Create Account API

  @CreateAccountAPI @deleteAccountAfter
  Scenario: Verify that is create Account with api
    Given I create by API new Account with following information:
      | name     | number | web           | phone | sicCode | fax   | employees |
      | franzAPI | 98     | www.franz.com | 6666  | 7854785 | 11111 | 8         |
    Then name should be displayed in detail Page Account