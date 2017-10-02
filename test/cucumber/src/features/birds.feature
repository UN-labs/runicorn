Feature: Birds object functions properly

    Scenario: Left should be a function
        Given I have an empty the_birds array
        When I have inserted a single Bird object
        Then the zeroeth bird has a function called left

    Scenario: Speed should be as expected
        Given I have an empty the_birds array
        When I have inserted a single Bird object
        Then the zeroeth bird has a speed of 2.5