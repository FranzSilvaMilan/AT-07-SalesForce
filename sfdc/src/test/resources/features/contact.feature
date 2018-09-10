@Login
Feature: Create new contact

  Background:
    Given I navigate to Login page
    And I login as "danny" User

  Scenario Outline: Verify that is possible create a new contact
    When I goes to "Contact" home page
    When I create a new contact "<contact>"
    Then verify if is create a new contact

    Examples:
      | contact   |
      | dinamarca |