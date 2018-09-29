@Oppy
Feature: Create a new Oppy.

  Background:
    Given I navigate to Login page
    And I login as "franz" User

  Scenario: Verify that is possible created a new Opporunity with Quote
    Given I have Account with following information:
        | name     | number | web           | phone | sicCode | fax   | employees |
        | franzAPI | 98     | www.franz.com | 6666  | 7854785 | 11111 | 8         |
      And I have a Product with the following information
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
        | abrzao | 09/27/2018 | Prospecting |
    Then The Opportunity should be displayed in details page
      And The Opportunity should be created
    When I create a new Quote with following information
        | quoteName  |
        | test quote |
      And I add the following line items
        | salesPrice | quantity |
        | 20555      | 50       |
    When The Quote should be displayed in details page
      And The Quote should be created

