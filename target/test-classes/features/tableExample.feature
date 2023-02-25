Feature: Table example

  Scenario: Verification and assertion about table
    Given Go to table page
    When user enter "name"
    Then table gives us that name's phone
    And table gives us that name's email
    And table gives us that name's address