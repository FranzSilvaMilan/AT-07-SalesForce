@Login
Feature: Create new contact

  Background:
    Given I navigate to Login page
    And I login as "danny" User
#    When I go to Contact home page

  @createContact
  Scenario: Verify that is possible create a new contact
    When I go to Contact home page
    And I click on New Contact
    When I fill the Account form name with
      | firstName | lastName | title    | phone  | homePhone | mobile | otherPhone | leadSource | mailingStreet       | lenguaje  | level    |
      | Irlanda   | Duchen1  | Prueba 1 | 123456 | 456123    | 789456 | 654987     | Web        | probando mas campos | Portugues | Tertiary |
    Then The name should be displayed in detail Page Contact

  @editContact @deleteContactAPI
  Scenario: Verify that is possible edit the contact
    When I go to Contact home page
    And I click on New Contact
    When I fill the Account form name with
      | firstName | lastName | title    | phone  | homePhone | mobile | otherPhone | leadSource     | mailingStreet       | lenguaje  | level   |
      | Suecia    | berlin   | Prueba 2 | 123456 | 456123    | 789456 | 654987     | Purchased List | probando mas campos | Portugues | Primary |
    When I Edit Contact with
      | firstName | lastName | mobile | title      |
      | Francia   | edit1    | 951263 | Automation |
    When I save the changes made
    Then Shows me the changes made

  @deleteContact @deleteContactAPI
  Scenario: Verify that is possible delete a cotact
    When I go to Contact home page
    And I click on New Contact
    When I fill the Account form name with
      | firstName | lastName | title    | phone  | homePhone | mobile | otherPhone | leadSource    | mailingStreet       | lenguaje  | level     |
      | prueba 31  | Duchen13   | Prueba 1 | 123456 | 456123    | 789456 | 654987     | Phone Inquiry | probando mas campos | Portugues | Secondary |
    When I click on option Delete Contact
    Then Verified that the contact has been removed

  @editContactAPI @deleteContactAPI
  Scenario: Verify that is create Contact with api
    Given I create by API new Contact with following information:
      | firstName | lastName | title     | phone  | homePhone | mobile | otherPhone | leadSource     | mailingStreet    | lenguaje     | level   |
      | Dinamarca | Rusia    | pruebaAPI | 123456 | 654123    | 789456 | 654987     | Purchased List | probando por API | Checoslovaco | Primary |
    Then name should be displayed in detail Page Contact
    When I go to Contact home page
    When I edit the Contact with the following information:
      | firstName | lastName | mobile | title       |
      | Lunny     | Tunes    | 378383 | prueba x ui |
    Then name should be displayed in detail Page Contact

