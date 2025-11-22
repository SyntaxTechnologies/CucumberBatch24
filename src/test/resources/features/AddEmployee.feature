Feature: Add employees in the system

  Background:
    When user enters valid username and password
    And user clicks on login button
    Then user is able to login successfully
    When user clicks on PIM option
    And user clicks on Add Employee button

  @add @smoke
  Scenario: Adding an employee normally
    When user enters firstname and middle name and lastname
    And user clicks on save button
    Then employee is added succesfully

  @param
  Scenario: Adding an employee using parameters
    When user enters "tariq" "ms" and "ahmed" values
    And user clicks on save button
    Then employee is added succesfully

  @examples @regression
  Scenario Outline: Adding an employee using examples table
    When user enters "<firstname>" "<middlename>" and "<lastname>" field values
    And user clicks on save button
    Then employee is added succesfully
    Examples:
      | firstname | middlename | lastname |
      |andrae     |ms          |zalaya    |
      |kevin      |ms          |adams     |
      |hamit     |ms          |ahmed      |

    @datatable @regression
    Scenario:Adding employees using data table
      When user enters firstname and middlename and lastname field values
      |firstname|middlename|lastname|
      |Ana      |ms        |Kinani  |
      |andrae     |ms          |zalaya    |
      |kevin      |ms          |adams     |
      |hamit     |ms          |ahmed      |

    @excel @regression
    Scenario: Adding employees using excel file
      When user enters firstname and middlename and lastname field values using excel and verify them









