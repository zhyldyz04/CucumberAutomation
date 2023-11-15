Feature: Unpaid invoices

  Scenario: Verifying unpaid invoices
    Given user goes to cashwise applicaton and successfully logs in
    Then user goes to Sales button
    And clicks on Invoice tab
    When user clicks on status button and sort for Not paid invoices
    Then user should see all unpaid invoices



