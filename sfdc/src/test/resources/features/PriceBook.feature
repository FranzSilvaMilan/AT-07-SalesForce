@PriceBook
Feature: Create a new PriceBook.

  Background:
    Given I navigate to Login page
    And I login as "franz" User

  Scenario Outline: Verify that is possible create a new PriceBook
    When I go to PriceBook list Page
    And I fill in required fields "<Title>", "<Description>"
    Then Should be displayed Detail PriceBook Page with "<Title>"
    Examples:
      | Title        | Description                    |
      | Practice GUI | This si a practice in the class |