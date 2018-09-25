Feature: Create a new Product.

  Background:
    Given I navigate to Login page
    And I login as "erik" User

  @createProduct
  Scenario: Verify that is possible create a new product with required fields
    When I go to Product list Page
    And I click a New Product
    And I fill in required fields
      | Product Name | Product Code | Product Description | Active | Product Family |
      | laptop       | 123          | product created     | false  | None           |
    Then Should be displayed Detail Product Page

  @editProduct @deleteProductAfter
  Scenario: Verify that is possible edit a Product
    When I go to Product list Page
    And I click a New Product
    And I fill in required fields
      | Product Name | Product Code | Product Description | Active | Product Family |
      | computer     | 1234564      | desktop             | false  | None           |
    When I edit Product
    And I fill fields for edit
      | Product Name | Product Code | Product Description | Active | Product Family |
      | new edited   | 98797        | product edited      | false  | None           |
    Then Should be displayed Detail Product Page

  @deleteProduct @deleteProductAfter
  Scenario: Verify that is possible delete a Product
    When I go to Product list Page
    And I click a New Product
    And I fill in required fields
      | Product Name | Product Code | Product Description | Active | Product Family |
      | computer2    | 123456478    | pc                  | true   | None           |
    When I delete Product
    Then The removed product should not be shown in the list

  @CreateProductAPI @deleteProductAfter
  Scenario: Verify that is create a Product with api
    Given I create by API new Product with following information:
      | Product Name | Product Code | Product Description     | Active | Product Family |
      | laptop gamer | 10101010     | product created for api | false  | None           |
    Then Name should be displayed in detail Page Product
    And I go to Product list Page
    When I edited Product with following information:
      | Product Name | Product Code | Product Description    | Active | Product Family |
      | pc1          | 20202020202  | product edited for api | false  | None           |
