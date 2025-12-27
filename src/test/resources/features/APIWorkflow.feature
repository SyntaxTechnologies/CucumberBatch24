Feature: API

  Background:
    Given a JWT is generated

  @api
  Scenario: Create an employee
    Given a request is prepared to create employee API
    When a POST call is made to create employee endpoint
    Then the status code for create employee API is 201
    Then the empNumber is stored for future use


 @api2
  Scenario: get employee
    Given a request is prepared to get employee API
    When a GET call is made to get employee endpoint
    Then the status code for get employee API is 200