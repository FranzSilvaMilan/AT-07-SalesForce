Feature: Create Price Book

  Background:
    Given I navigate to Login page
    And I login as "franz" User

  Scenario: verify that is posible create a new PriceBook
    Given I go to PriceBook Home Page
    And I click on New Button
    When I create a New PriceBook with the following information: "Test Create first" , "This is a test", "true"
    Then BookPrice Details Page should be display with the information of the product created