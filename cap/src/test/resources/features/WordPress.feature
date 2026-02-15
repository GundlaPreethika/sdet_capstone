Feature: WordPress Web site Validation

  Scenario: Verify WordPress functionalities

    Given User launches WordPress web site
    Then Verify title of page
    When User mouse over Download & Extend and click Get WordPress
    Then Verify middle text as "Get WordPress"
    When User clicks on Community and Photo Directory
    And User searches for picture "nature"
    Then Verify pictures are displayed