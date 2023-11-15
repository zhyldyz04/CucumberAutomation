
@search @smoke @google @regression
Feature: Google search

  #UserStory: SUP-93


  Scenario: Verifying the result for search
    Given I am on the google page
    When I search for "cucumber"
    Then I should see only "cucumber" related results



    Scenario:Verifying image result
      Given  I am on the google page
      When I search for "James Bond"
      And I click on image option
      Then I should see only "James Bond" related images