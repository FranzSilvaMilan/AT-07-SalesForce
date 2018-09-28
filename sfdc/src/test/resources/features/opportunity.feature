@Opportunities
Feature: Create a new Opportunities.

  Background:
    Given I navigate to Login page
    And I login as "danny" User

  Scenario: Verify that is possible created a new Opporunity with Quote
    Given I have Account with following information:
      | name     | number | web           | phone | sicCode | fax   | employees |
      | franzAPI | 98     | www.franz.com | 6666  | 7854785 | 11111 | 8         |
      And I have a Product with the following information:
        | Product Name | Product Code | Product Description | Active | Product Family |
        | computer     | 1234564      | desktop             | false  | None           |
      And I go to Product list Page
      And I select the Product in Product list page
      And I add Standard Price to Product with "456"
      And I add the Product to Price Book Standard with List Price "741"
    When I go to Opportunities list Page
      And I click on New Opportunity button
      And I created an Opportunity with the following information
        | name   | closeDate  | stage       |
        | abrzao | 30/09/2018 | Prospecting |
    Then the Opportunity should be displayed in details page
    When I create a new Quote with following information
        | quoteName  |
        | test quote |
      And I add the following line items
        | price | quantity |
        | 20555 | 50       |
    Then the Quotes should be displayed in details page
