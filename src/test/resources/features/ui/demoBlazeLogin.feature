Feature: DemoBlaze Login



  Scenario: Verifying the login functionality positive
    Given user is on a demoblaze application
    And user clicks on login button for demo blaze
    When user enters credentials "username" and "password" and clicks login
    Then user should successfully login to application


