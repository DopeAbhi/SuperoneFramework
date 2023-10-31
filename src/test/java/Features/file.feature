Feature: Validating login

  Scenario: Basic login

    Given User Status Payload with "<Parent_Email>"
    When user calls with "Post" http request
    Then the API call got success with status code 200