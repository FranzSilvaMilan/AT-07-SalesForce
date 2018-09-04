@Login
Feature: Login
  Test successfully and unsuccessfully login and logout

  @SmokeTest @Logout
  Scenario Outline: Users should be able to login using valid credentials
    Given I navigate to Login page
    When I login as "<User Name>" with password "<Password>"
    Then I should login successfully

    Examples: Short pass
      | User Name            | Password    |
      | daniels@estudent.com | blackmoon10 |

  Scenario Outline: Users should not be able to login using invalid credentials
    When I login as "<User Name>" with password "<Password>"
    Then I should not login successfully
    Examples: Short pass

      | User Name      | Password | Message                                                                                                |
      | svala@at05.com | Con123!  | Check your username and password. If you still can not sign in, contact your Salesforce administrator. |
