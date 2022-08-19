Feature:login feature

  @login
  Scenario: valid Admin login
    Given user is navigated to the specified url
    When  user enters a valid username and password
    And   click on login button
    Then  the user is able to see the message Welcome Admin

