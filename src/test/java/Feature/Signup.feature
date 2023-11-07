Feature: Validating login

 Scenario Outline: Signup

    Given User Status Payload with "<Email>"
    When user calls "initiate_login" with Post http request
    Then the API call got success with status code 200
   Examples:
     | Email |
     |max6400@y.com|

   Scenario:
   Given User verification url
   When User call "get_verification_url" with Get http request
   Then the API call got success with status code

