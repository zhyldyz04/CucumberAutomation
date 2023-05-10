Feature: Employee Data Validation

  @verifyNewEmployee
  Scenario: Verify the creation of a new employee
    Given I have access to the database
    When I create a new employee with 9999, "'Jenn'", "'Coco'", "'coco@gmail.com'", "'111.111.1111'", "'20-JUL-20'", 4, 3000, 100, 10
    Then the record should be successfully inserted
    And when I query for the record with employee_id 9999, I should receive the correct details