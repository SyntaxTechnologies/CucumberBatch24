Feature: User story 12345 - Login related scenarios

  Background:
    #Given user is able to access HRMS application

  @login @yasir @sprint1 @ana @smoke @sprint22
  Scenario: Valid admin login
    When user enters valid username and password
    And user clicks on login button
    Then user is able to login successfully

  @invalid @sprint2 @regression
  Scenario: Invalid admin login
    #Given user is able to access HRMS application
    When user enters invalid username and password
    And user clicks on login button
    Then user is able to see error message






