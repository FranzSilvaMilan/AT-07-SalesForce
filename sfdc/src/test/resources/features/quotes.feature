Feature: Create a new Quote.

  Background:
    Given I navigate to Login page
    And I login as "erik" User

  Scenario:Verify that is possible created a new Quote
    Given I have Account with following information:
      | name     | number | web           | phone | sicCode | fax   | employees |
      | franzAPI | 98     | www.franz.com | 6666  | 7854785 | 11111 | 8         |

    When I go to Opportunitie List Page
    And I click on New Opportunitie
    When I created opportunity with the following information
      | name   | accountName | closeDate  | stage       |
      | abrzao | silvaMap    | 09/27/2018 | Prospecting |
    Then The opportunity should be displayed in details page
    When I create a new Quote with "Test" Name
    And The following line item
      | quoteName  | price | quantity |
      | test quote | 0     | 50       |

