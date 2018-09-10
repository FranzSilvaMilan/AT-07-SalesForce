Feature: Create a new Product.

  Background:
    Given I navigate to Login page
    And I login as "erik" User

  Scenario Outline: Verify that is possible create a new product with required fields.
    When I go to Product Home Page
    And I fill in required fields "<Products name>"
    Then Should be displayed Detail Product Page with "<Products name>"
    Examples:
      | Products name |
      | Butter        |

