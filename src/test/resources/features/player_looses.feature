Feature: User looses


  As a user , when I loose a round, I should get detailed messages about the game status



  Background: Round Start
    Given a new round
    When the player has 100 coins
    And the dealer has 100 coins
    And the dealer makes a bet of 99

  Scenario:User looses round
    When the player makes a bet of 99
    And the player looses the round
    Then the player should have 1 coin
    And the dealer should have 199 coin

  Scenario:User looses round and is out of money
    When the player makes a bet of 100
    And the player looses the round
    Then the player should have 0 coin
    And the player should be informed the game is over