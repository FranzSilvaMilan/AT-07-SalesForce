Feature: Create a new Product.

  Background:
    Given I navigate to Login page
    And I login as "erik" User

  Scenario: Verify that is possible create a new product with required fields.
    When I go to Product list Page
    And I click a New Product
    And I fill in required fields
      | Product Name | Product Code | Product Description | Active | Product Family |
      | butter 1     | 123          | sdf                 | false  | None           |
    Then Should be displayed Detail Product Page



