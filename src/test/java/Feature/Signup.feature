Feature: Validating login

 Scenario Template: Signup

    Given User Status Payload with "<Email>"
    When user calls "initiate_login" with Post http request
    Then the API call got success with status code 200
   Examples:
     | Email         |
     | max6523@y.com |

  Scenario: Get Verification Url
   Given User verification url
   When User call "get_verification_url" with Get http request
   Then the API call got success with status code

  Scenario:Verify Url
   Given Verifying user with token
   When Call "verify_url" with Post http request
   Then Verification of status code 200

Scenario Outline: Verification Check of User
  Given Verification check of "<Emaill>"
  When Verification check "verification_check" with end url
  Then Verification of Status
  Examples:
    | Emaill        |
    | max6523@y.com |

  Scenario Outline: Set Password of User
    Given Verification of user password with "<Password>"
    When Setting password with patch request "set_password"
    Then Checking password set successfully
    Examples:
      | Password |
      | Test@123 |

    Scenario Outline: Veriy Referral
      Given Verifying user "<Email>" with "<Referral>"
      When Setting referral with post request "verify_referral"
      Then Checking referral get successfully
      Examples:
        | Email          | Referral |
        | max6523@y.com | amrendra |

      Scenario Outline: Set Username
       Given Setting username with "<username>"
        When Setting username with patch request "set_username"
        Then Checking username set successfully
        Examples:
          | username |
          | max6523  |

  Scenario Outline: Set First and Last Name
          Given Setting first and last name with "<first_name>"
          When Setting first and last name with put request "set_firstname_lastname"
          Then Checking first and last name set successfully
          Examples:
            | first_name |
            | max6523   |

    Scenario: Setting Avatar
      Given Setting avatar of the user
      When Setting avatar with patch request "set_avatar"
      Then Checking avatar set successfully
