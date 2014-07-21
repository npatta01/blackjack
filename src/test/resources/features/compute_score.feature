Feature: Score of hand is computed correctly

  The app correclty scores the hand ideally

  Scenario Outline: Compute Score form hand
    Given an empty hand
    And a card in the hand is <card1>
    And a card in the hand is <card2>
    And a card in the hand is <card3>
    Then the score should be <score>


  Examples:Non special card
    | card1 | card2 | card3  | score|
    | Hearts 4 | Spades 2 | None  |  6   |
    | Clubs 8 | Diamonds 3 | None  |  11   |
    | Clubs 3 | Hearts 8 | Spades 7  |  18   |
    | Diamonds 9 | Hearts 7 | Spades 9  |  25   |



  Examples:King, Queens, Jack
    | card1 | card2 | card3  | score|
    | Hearts King | Spades 3 | Spades 8  |21|
    | Hearts Queen | Spades 3 | Spades 8  |21|
    | Hearts Jack | Spades 3 | Spades 8  |21|


  Examples:Ace
    | card1 | card2 | card3  | score|
    | Hearts 4 | Spades 2 |  Hearts Ace |  17   |
    | Hearts 9 | Spades 2 | Spades Ace  |  12   |
    | Hearts 9 | Spades Ace | Spades Ace  |  21   |
    | Hearts Queen | Spades Ace | Spades Ace  |  12   |