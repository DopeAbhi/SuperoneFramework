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

    Scenario: Sender Settings
      Given Getting sender settings details
      When Sender settings with get request "checking_settings"
      Then Checking sender settings status

  Scenario Outline: Receiver Login
    Given Receiver credentials "<Email>" and "<Password>"
    When Receiver login with patch request "login"
    Then Checking user login status and extracting token & referral
    Examples:
      | Email | Password |
      | max6521@y.com | Test@123 |


  Scenario: Searching User for Transfer
      Given Searching user for transfer
      When Searching user for transfer with post request "member_search"
      Then Checking user search status and extracting member id


    Scenario Outline: Transfer
      Given Transfer details "<Amount>"
      When Transfer with post request "transfer"
      Then Checking transfer status
      Examples:
        | Amount |
        | 10 |

  Scenario: Getting Receiver Wallet Details
    Given Getting receiver wallet data
    When Receiver wallet data with get request "get_walletdata"
    Then Checking receiver wallet data status