Feature: Authentification Use case cases : Valid and Incorrect credentials

  Scenario Outline: Auth use case 1 : Valid Credentials - The user Logs in successfully
    Given the user is on the main page of conduit
    When the user clicks on the button
    Then the user is redirected to the login page
    When the user fill his "<email>"
    And the user fill his password "<password>"
    And the user clicks on Sign in Button
    Then the user can log to his account
    Examples:
      | email                |password |
      | haibeismail@gmail.com |Rmq8JEkUPPt6eES|

  Scenario Outline: Auth use case 2 : Incorrect Credentials - The user does not Log in successfully
    Given the user is on the main page of conduit
    When the user clicks on the button
    Then the user is redirected to the login page
    When the user fill his "<email>"
    And the user fill his password "<password>"
    And the user clicks on Sign in Button
    Then the user gets an error message
    Examples:
      | email                |password |
      | haiber@gmail.com |Rmq8JEkUPPt6eES|


  Scenario Outline: Auth use case 3 : The user logs in and logs out successuflly
    Given the user is on the main page of conduit
    When the user clicks on the button
    Then the user is redirected to the login page
    When the user fill his "<email>"
    And the user fill his password "<password>"
    And the user clicks on Sign in Button
    Then the user can log to his account
    When the user clicks on his profile
    And the user clicks on Edit Profile Settings
    Then the user is on the settings
    And the user can click on the button to logout

    Examples:
      | email                |password |
      | haibeismail@gmail.com |Rmq8JEkUPPt6eES|