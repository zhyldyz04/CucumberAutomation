Feature: Search Transactions

  @cashwise
  Scenario: Search for transactions in Transactions page
    Given I on cashwise home page
    When I click on "reports" button and click "transactions" button
    And i should click on "add expenses" button and create an expense
    Then I should be able to search specific transaction

