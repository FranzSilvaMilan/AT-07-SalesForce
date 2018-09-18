@Login
Feature: Edit contact

  Background:
    Given I navigate to Login page
    And I login as "danny" User

  Scenario: Verify that a created contact can be modified
    When I go to Contact home page
    And I click on New Contact
    When I fill the Account form name with
      | firstName | lastName | title      | phone  | homePhone | mobile | otherPhone |
      | Daniel    | Sandoval | Examen GUI | 123456 | 456123    | 789456 | 654987     |
    Then The name should be displayed in detail Page Contact
    When I click on Edit button
      | mobile | title      |
      | 951263 | Automation |
    When I save the changes made
    Then Shows me the changes made