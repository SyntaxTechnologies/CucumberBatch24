Feature: API

  Background:
    Given a JWT is generated

  @api
  Scenario: Create an employee
    Given a request is prepared to create employee API
    When a POST call is made to create employee endpoint
    Then the status code for create employee API is 201
    Then the empNumber is stored for future use

 @api
  Scenario: get employee
    Given a request is prepared to get employee API
    When a GET call is made to get employee endpoint
    Then the status code for get employee API is 200

  @api
  Scenario: Update the employee
    Given a request is prepared to update employee API
    When a PUT call is made to update employee endpoint
    Then the status code for update employee API is 200

  @api2
  Scenario: Create an employee
    Given a request is prepared to create employee API with parameterized payload
    When a POST call is made to create employee endpoint
    Then the status code for create employee API is 201
    Then the empNumber is stored for future use


  @api3
  Scenario: Create an employee
    Given a request is prepared to create employee API with json payload
    When a POST call is made to create employee endpoint
    Then the status code for create employee API is 201
    Then the empNumber is stored for future use

  @api4
  Scenario: Create an employee using dynamic json payload
    Given a request is prepared to create employee API with json payload by "John" and "Doe" and "Smith" and "EMP241"
    When a POST call is made to create employee endpoint
    Then the status code for create employee API is 201
    Then the empNumber is stored for future use