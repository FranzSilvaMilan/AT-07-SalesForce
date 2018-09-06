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

  @SmokeTest @Logout
  Scenario Outline: Users should not be able to login using invalid credentials
    When I login as "<User Name>" with password "<Password>"
    Then I should not login successfully "<Message>"

    Examples: Short pass
      | User Name            | Password | Message                                                                                                                                 |
      | daniels@estudent.com | Co84547  | Compruebe su nombre de usuario y contraseña. Si sigue sin poder iniciar sesión, póngase en contacto con su administrador de Salesforce. |
