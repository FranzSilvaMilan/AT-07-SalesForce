Feature: Create a new Product.

  Background:
    Given I navigate to Login page
    And I login as "erik" User
    When I go to Product list Page
    And I click a New Product

  Scenario: Verify that is possible create a new product with required fields
    And I fill in required fields
      | Product Name | Product Code | Product Description | Active | Product Family |
      | butter 1     | 123          | sdf                 | false  | None           |
    Then Should be displayed Detail Product Page

  #Scenario: Verify that is possible edit a Product
    When I edit Product
    And I fill fields for edit
      | Product Name | Product Code | Product Description | Active | Product Family |
      | editado      | 44444        | hola                | false  | --None--       |

  #Scenario: Verify that is possible delete a Product
    When I delete Product
    Then Should be displayed message delete successfully



