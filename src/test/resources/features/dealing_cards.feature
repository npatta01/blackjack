Feature: Deals card to user at start of game and hit


  As a player, when a card is dealt, it should be placed in the hand of the current player or dealer



  Background: Round Start
    Given a new round
    And the following next cards in the deck:
      | Hearts 2|
      | Spades 2|
      | Spades 9 |
      | Spades 8 |
      | Clubs 9 |
      | Clubs 4 |
      | Clubs 2 |

  Scenario:Card is dealt alternatingly to each user
    When the round starts
    And the player chooses to stand
    Then player should have the following cards:
      | Hearts 2|
      | Spades 9 |

    And  dealer should have the following cards:
      | Spades 2|
      | Spades 8 |


  Scenario:Player hits
    When the round starts
    And the player chooses to hit
    Then player should have the following cards:
      | Hearts 2|
      | Spades 9 |
      | Clubs 9 |