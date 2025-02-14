Feature: Login

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be redirected to the home page

  Scenario: Successful login with invalid credentials
    Given the user is on the login page
    When the user enters invalid credentials
    Then the user should see an error message

  Scenario Outline: Login with different credentials as data driven
    Given the user is on the login page
    When the user enters "<username>" in the username field
    And the user enters "<password>" in the passwrod field
    And the user clicks button
    Then the user should be redirected to the "<targetpage>" page
    Examples:
      | username | password | targetpage    |
      | Admin    | admin123 | dashboardpage |
      | Admin    | 2342443  | errorpage     |