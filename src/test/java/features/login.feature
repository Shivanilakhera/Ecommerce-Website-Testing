Feature: Login

  Scenario: Login with valid credentials
    Given I open the login page
    When I enter my username and password
    And I click the login button
    Then I should be logged in successfully
