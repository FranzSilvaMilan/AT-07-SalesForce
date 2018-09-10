@Login
Feature: Create new PriceBook

  @SmokeTest @Logout
  Scenario Outline: Verify that the user can create a price book
    Given I navigate to Login page
      And I login as "danny" User
    When I click in the option Price Book
    When I click in New button
    When Fill the empty fields "<Title>", "<Description>" and put active "<Active>"
    Then Create a new Price Book

    Examples:
      | Title        | Description                    | Active |
      | Practice GUI | This si a practice inthe class | true   |