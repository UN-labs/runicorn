Feature: Game is playable as expected

  Background:
    Given I am on the Runicorn homepage

  Scenario: Gameplay is started on a new game
    Given the start game button is active
    And the restart button is inactive
    When I click start game
    Then the game starts

  Scenario: Gameplay is restarted on a finished game
    Given the start game button is inactive
    And the restart button is active
    When I click restart game
    Then the game starts

  Scenario: While game is active I am able to jump
    Given I have started the game
    When I press the space bar
    Then My unicorn jumps