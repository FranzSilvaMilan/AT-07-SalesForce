@Login
Feature: Create new contact

  Background:
    Given I navigate to Login page
    And I login as "danny" User

  Scenario: Verify that is possible create a new contact
    When I go to Contact home page
    And I click on New Contact
    When I fill the Account form name with
      | firstName | lastName | title    | phone  | homePhone | mobile | otherPhone |
      | Meriland  | Duchen   | Prueba 1 | 123456 | 456123    | 789456 | 654987     |

    Then The name should be displayed in detail Page Contact