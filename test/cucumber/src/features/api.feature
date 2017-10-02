Feature: Api functions properly

    Scenario: Memory endpoint saves
        Given the API is running
        When I send a get request to memory endpoint with a value of test
        Then the API returns test

    Scenario: Memory endpoint recalls
        Given the API is running
        When I send a get request to memory_check endpoint
        Then the API returns test