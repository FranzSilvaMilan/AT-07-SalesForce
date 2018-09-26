Feature: Create a new Quote.

  Background:
    Given I navigate to Login page
    And I login as "erik" User

  Scenario: Verify that is possible created a new Opporunity with Quote
#    I have Account with following information:
    Given I have Account with following information:
      | name     | number | web           | phone | sicCode | fax   | employees |
      | franzAPI | 98     | www.franz.com | 6666  | 7854785 | 11111 | 8         |
#     I have a Product with the following information
    And I create by API new Product with following information:
      | Product Name | Product Code | Product Description | Active | Product Family |
      | computer     | 1234564      | desktop             | false  | None           |
#    And I add Standar Price to Product with "456"
#    And I add the Product to Price Book Standard with List Price "741"
    When I go to Opportunities list Page
    And I click on New Opportunity button
    And I created an Opportunity with the following information
      | name   | accountName | closeDate  | stage       |
      | abrzao | silvaMap    | 09/27/2018 | Prospecting |
    Then The Opportunity should be displayed in details page
    When I create a new Quote with following information
      | quoteName  |
      | test quote |
      And I add the following line items
        | price | quantity |
        | 20555 | 50       |

