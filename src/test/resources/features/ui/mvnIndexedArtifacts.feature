Feature: MVN Repository Indexed Artifacts

  Scenario: Verifying Indexed Artifacts link on mvn repository
    Given When user is on mvnrepository application
    When user clicks on Indexed Artifacts link
    Then user should see header "Top 20 repositories"
    And user should see the list of "20" repositories in the result
