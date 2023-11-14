Feature: Validating login

  @Regression
    Scenario Outline: : Checking User status

    Given Checking user status with "<Email>"
    When user calls "initiate_login" with post request
    Then Checking status of user status
    Examples:
      | Email |
      |max6521@y.com |

  @Regression
 Scenario Outline: Login
    Given User Login with "<Email>"
    When Login with Patch "login" request
    Then the API call got success status code
    Examples:
      | Email |
      |max6521@y.com |