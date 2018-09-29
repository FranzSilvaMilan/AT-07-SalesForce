@Contact
Feature: Create new contact

  Background:
    Given I navigate to Login page
    And I login as "franz" User

  @deleteContact
  Scenario: Verify that is possible create a new contact
    When I go to Contact list page
      And I click on New Contact button
    When I create the Contact with the following information
      | firstName | lastName | title    | phone  | homePhone | mobile | otherPhone | leadSource | mailingStreet       | lenguaje  | level    |
      | Irlanda   | Duchen1  | Prueba 1 | 123456 | 456123    | 789456 | 654987     | Web        | probando mas campos | Portugues | Tertiary |
    Then the Contact information should be displayed in Contact Details page
      And the Contact should be created

  @deleteContact
  Scenario: Verify that is create Contact with api
    Given I have a Contact with the following information:
      | firstName | lastName | title     | phone  | homePhone | mobile | otherPhone | leadSource     | mailingStreet    | lenguaje     | level   |
      | Dinamarca | Rusia    | pruebaAPI | 123456 | 654123    | 789456 | 654987     | Purchased List | probando por API | Checoslovaco | Primary |
    When I go to Contact list page
      And I select the Contact in Contact list page
      And I click on Edit Contact button
     And I edit the Contact with the following information
        | firstName | lastName | mobile | title       |
        | Lunny     | Tunes    | 378383 | prueba x ui |
    Then the Contact information should be displayed in Contact Details page
      And the Contact should be edited

  @deleteContact
  Scenario: Verify that is possible delete a cotact
    Given I have a Contact with the following information:
      | firstName | lastName | title     | phone  | homePhone | mobile | otherPhone | leadSource     | mailingStreet    | lenguaje     | level   |
      | Dinamarca | Rusia    | pruebaAPI | 123456 | 654123    | 789456 | 654987     | Purchased List | probando por API | Checoslovaco | Primary |
    When I go to Contact list page
      And I select the Contact in Contact list page
      And I click on Delete Contact button
    Then the Contact should be removed in Contact list page
      And the Contact should be removed