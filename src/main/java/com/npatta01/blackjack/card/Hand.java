package com.npatta01.blackjack.card;

import java.util.ArrayList;
import java.util.List;

/**
 * A hand of cards
 */
public class Hand {


    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>(5);
    }

    public void addCard(Card c) {
        cards.add(c);
    }

    /**
     * Get the value of a hand
     * Calcualtes the optimal value for Ace based on other cards in hand
     * @return
     */
    public int getScore() {
        int num_aces = 0;

        int hand_score = 0;
        //sum the score of cards
        for (Card c : cards) {
            int score = c.getCardValue();

            if (c.getRank() == Rank.ACE) {//if ace , use score 11
                num_aces++;
                hand_score += 11;
            } else {
                hand_score += score;
            }
        }

        while (hand_score > 21 && num_aces > 0) {//if exceeded 21 and there is Ace, count as one
            hand_score -= 10;
            num_aces -= 1;

        }


        return hand_score;
    }


    /**
     * Clear the cards in hand
     */
    public void clearHand() {
        cards.clear();
    }

    /**
     * Get cards in hand
     *
     * @return
     */
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hand hand = (Hand) o;

        return cards.size() == hand.cards.size() && cards.containsAll(hand.cards);
    }

    @Override
    public int hashCode() {
        return cards.hashCode();
    }
}
