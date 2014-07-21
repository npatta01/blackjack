Feature: User wins
  As a user , when I win a round, I should get detailed messages about the game status



  Background: Round Start
    Given a new round
    And the following next cards in the deck:
      | Hearts 9|
      | Spades 7|
      | Spades 9 |
      | Spades 8 |
      | Clubs 9 |
      | Clubs 4 |
      | Clubs 2 |
      | Clubs 3 |

    When the player has 100 coins
    And the dealer has 100 coins
    And the player makes a bet of 99




  Scenario:User wins round
    And the dealer makes a bet of 10
    And the player chooses to stand
    When the round is over
    Then the player should have 110 coin
    Then the dealer should have 10 coin

