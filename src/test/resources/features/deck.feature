Feature: Deck

  As a player, I want to be sure that the deck is shuffled

  Scenario: New Deck
    Given a deck of cards
    When the deck is shuffled
    Then the order of cards should be changed