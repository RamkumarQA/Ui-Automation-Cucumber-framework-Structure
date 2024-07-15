Feature: Login Feature

  Scenario Outline: Login successfully and verify home page title
    Given the user is on the login page
    When the user enters "<username>" and "<password>"
    And clicks on the login button
    Then the user should be redirected to the home page
    And the home page title should be "<title>"

    Examples:
      | username       | password  | title                         |
      | mngr578691     | UsAtEpU   | Guru99 Bank Manager HomePage  |
