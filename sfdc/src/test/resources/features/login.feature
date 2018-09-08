@Login
Feature: Login
  Test successfully and unsuccessfully login and logout

  Background:
    Given I navigate to Login page

  @SmokeTest @Logout
  Scenario Outline: Users should be able to login using valid credentials
    When I login as "<User Name>" with password "<Password>"
    Then I should login successfully "<User>"

    Examples: Short pass
      | User Name           | Password  | User        |
      | Erik.Vargas@fundacion-jala.org | albertoerik8492 | Erik Vargas |

  @SmokeTest @Logout
  Scenario Outline: Users should not be able to login using invalid credentials
    When I login as "<User Name>" with password "<Password>"
    Then I should not login successfully "<Message>"

    Examples:
      | User Name            | Password | Message                                                                                                    |
      | daniels@estudent.com | Co84547  | Please check your username and password. If you still can't log in, contact your Salesforce administrator. |
