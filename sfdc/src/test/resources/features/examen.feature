Feature: Edit a Product.

  Background:
    Given I navigate to Login page
    And I login as "erik" User

  Scenario: Verify that is possible edit a product.
    When I go to Product list Page
    And I click a New Product
    And I fill in required fields
      | Product Name | Product Code | Product Description | Active |
      | butter 1     | 123          | sdfasdfas           | true   |
    Then Should be displayed Detail Product Page

    When I click a edit Product
    And I fill fields
      | Product Name | Product Code |
      | editado      | 44444        |
    Then Should be displayed list Product Page