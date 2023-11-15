Feature: Employee Data Validation

  @verifyNewEmployee
  Scenario: Verify the creation of a new employee
    Given I have access to the database
    When I create a new employee with 9981, "Jane", "Cece", "cece@gmail.com", "111.611.1111", "18-JUL-20", 4, 3000, 100, 10
    Then the record should be successfully inserted


    @verifyTheChanges
    Scenario Outline: Verify the salary is updated
      Given I have access to the database
      When I update the "<column_name>" of <employee_id> with the new value <new_value>
      Then "<column_name>" of <employee_id> must be equal to <new_value>

      Examples:
      |column_name|employee_id|new_value|
      |salary     |9981       |5000     |
      |manager_id   |9981       |102      |