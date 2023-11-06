Feature: Validating login

  @Regression
  Scenario: Basic login

    Given User Status Payload with Email
    When user calls with "initiate_login" http request
    Then the API call got success with status code
  @Regression
  Scenario: Login
    Given User Login with Email
    When Login with Patch "login" request
    Then the API call got success status code