Feature: Signup

  Scenario: Successful signup
    Given I navigate to the Magento homepage
    When I go to the create account page
    And I enter valid signup details
    And I submit the form
    Then My account should be created successfully
