Feature:login feature
  Background:
    Given user is navigated to the specified url
  @login
  Scenario: valid Admin login
    When user enters a valid "Admin" and "Hum@nhrm123"
    And click on login button
    Then the user is able to see the message Welcome Admin

  @login
Scenario Outline: Invalid Credentails
 When user enters different "<username>" and "<password>" and verify the "<error>"
  Examples:
    | username | password | error |
    |admin     |xyz       |Invalid credentials|
    |cristiano |Hum@n     |Invalid credentials|
    |          |Hum@nhrm123|Username cannot be empty|
    |admin     |           |Password cannot be empty|


