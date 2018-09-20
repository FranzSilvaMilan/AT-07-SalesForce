Feature: Create a new Product.

  Background:
    Given I navigate to Login page
    And I login as "erik" User
    When I go to Product list Page
    And I click a New Product

  Scenario: Verify that is possible create a new product with required fields
    And I fill in required fields
      | Product Name | Product Code | Product Description | Active | Product Family |
      | laptop       | 123          | product created     | false  | None           |
    Then Should be displayed Detail Product Page

  Scenario: Verify that is possible edit a Product
    And I fill in required fields
      | Product Name | Product Code | Product Description | Active | Product Family |
      | computer     | 1234564      | desktop             | false  | None           |
    When I edit Product
    And I fill fields for edit
      | Product Name | Product Code | Product Description | Active | Product Family |
      | new edited   | 98797        | product edited      | false  | None           |
    Then Should be displayed Detail Product Page

  Scenario: Verify that is possible delete a Product
    And I fill in required fields
      | Product Name | Product Code | Product Description | Active | Product Family |
      | computer2    | 123456478    | pc                  | true   | None           |
    When I delete Product
    Then The removed product should not be shown in the list