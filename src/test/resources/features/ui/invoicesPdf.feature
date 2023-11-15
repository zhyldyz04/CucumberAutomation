Feature:Cashwise invoice pdf view


  Scenario:  Verify a showing Invoices in PDF version

    Given User is on the Cashwise web page
    And   User logs in with valid credentials in CashWise
    Then  User User clicks on the Sales menuBar
    And   User clicks on the Invoice bar
    When  User clicks on the three dots menu bar and application should offer Show PDF version option
    And  User choose Show PDF version and clicks on it
    Then User should be able to see PDF file and "Download PDF" option