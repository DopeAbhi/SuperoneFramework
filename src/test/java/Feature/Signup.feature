Feature: Validating login

 Scenario Outline: Signup

    Given User Status Payload with "<Email>"
    When user calls "initiate_login" with Post http request
    Then the API call got success with status code
   Examples:
     | Email |
     |max600@y.com|
