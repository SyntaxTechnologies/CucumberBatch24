Feature: Search employees in the system

  Background:
    #Given user is able to access HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is able to login successfully
    When user clicks on PIM option
    And user clicks on employee list option

  @employee @ivana @sprint2
  Scenario: Search employee by id
    When user enters valid employee id
    And user clicks on search button
    Then user is able to see the employee details

  @smoke @employee @sprint3 @nabil
  Scenario: Search employee by name
    When user enters valid employee name
    And user clicks on search button
    Then user is able to see the employee details
