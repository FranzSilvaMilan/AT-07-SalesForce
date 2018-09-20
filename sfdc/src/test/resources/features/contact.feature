@Login
Feature: Create new contact

  Background:
    Given I navigate to Login page
    And I login as "danny" User

  Scenario: Verify that is possible create a new contact
    When I go to Contact home page
    And I click on New Contact
    When I fill the Account form name with
      | firstName | lastName | title    | phone  | homePhone | mobile | otherPhone | leadSource | mailingStreet       | lenguaje  | level    |
      | prueba 11  | Duchen1   | Prueba 1 | 123456 | 456123    | 789456 | 654987     | Web        | probando mas campos | Portugues | Tertiary |

    Then The name should be displayed in detail Page Contact

  Scenario: Verify that is possible edit the contact
    When I go to Contact home page
    And I click on New Contact
    When I fill the Account form name with
      | firstName | lastName | title    | phone  | homePhone | mobile | otherPhone | leadSource     | mailingStreet       | lenguaje  | level   |
      | prueba 21  | Duchen12   | Prueba 1 | 123456 | 456123    | 789456 | 654987     | Purchased List | probando mas campos | Portugues | Primary |
    When I Edit Contact with
      | firstName  | lastName | mobile | title      |
      | prueba 2.11 | edit1     | 951263 | Automation |
    When I save the changes made
    Then Shows me the changes made

  Scenario: Verify that is possible delete a cotact
    When I go to Contact home page
    And I click on New Contact
    When I fill the Account form name with
      | firstName | lastName | title    | phone  | homePhone | mobile | otherPhone | leadSource    | mailingStreet       | lenguaje  | level     |
      | prueba 31  | Duchen13   | Prueba 1 | 123456 | 456123    | 789456 | 654987     | Phone Inquiry | probando mas campos | Portugues | Secondary |
    When I click on option Delete Contact
    Then Verified that the contact has been removed