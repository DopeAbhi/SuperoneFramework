Feature: Testing Transfer

  Scenario Outline:Sender Login
    Given Sender credentials "<Email>" and "<Password>"
    When Sender login with patch request "login"
    Then Checking user login status and extracting token
    Examples:
      | Email | Password |
      | max6523@y.com | Test@123 |


  Scenario: Getting Sender Wallet Details
    Given Getting sender wallet data
    When Sender wallet data with get request "get_walletdata"
    Then Checking sender wallet data status

