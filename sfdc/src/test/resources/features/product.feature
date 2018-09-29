@Product
Feature: Create a new Product.

  Background:
    Given I navigate to Login page
      And I login as "franz" User

  @deleteProduct
  Scenario: Verify that is possible create a new product
    When I go to Product list Page
      And I click a New Product button
    When I have a Product with the following information:
        | Product Name | Product Code | Product Description | Active | Product Family |
        | laptop       | 123          | product created     | false  | None           |
    Then the Product information should be displayed in Product Details page
      And the Product should be created

  @deleteProduct
  Scenario: Verify that is create a Product with api

    Given I have a Product with the following information
      | Product Name | Product Code | Product Description     | Active | Product Family |
      | laptop gamer | 10101010     | product created for api | false  | None           |
    When I go to Product list Page
      And I select the Product in Product list page
      And I click on Edit Product button
      And I edited Product with following information:
        | Product Name | Product Code | Product Description    | Active | Product Family |
        | pc1          | 20202020202  | product edited for api | false  | None           |
    Then the Product information should be displayed in Product Details page
      And the Product should be created

  @deleteProduct
  Scenario: Verify that is possible delete a Product

    Given I have a Product with the following information
      | Product Name | Product Code | Product Description | Active | Product Family |
      | computer2    | 123456478    | pc                  | true   | None           |
    When I go to Product list Page
      And I select the Product in Product list page
      And I click on Delete Product button
    Then The removed product should not be shown in the list
