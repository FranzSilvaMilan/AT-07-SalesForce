@Login
Feature: Create new contact

  Background:
    Given I navigate to Login page
      And I login as "danny" User

  Scenario Outline: Verify that is possible create a new contact
    When I goes to "Contact" home page
      And I click on New Contact
    When I fill the Account form name with: "<contact>"
    Then "<contact>" name should be displayed in detail Page Contact

    Examples:
      | contact   |
      | dinamarca |