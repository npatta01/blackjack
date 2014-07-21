package com.npatta01.blackjack.player;

import com.npatta01.blackjack.card.Card;
import com.npatta01.blackjack.card.Hand;

/**
 * Represents a player in a blackjack card game
 */
public abstract class BasePlayer {

    //money that the user has for betting
    protected int money;

    //player's current handf
    protected Hand hand;

    /**
     * Cosntuctor
     * @param hand
     */
    public BasePlayer(Hand hand) {
        this.hand = hand;

    }

    /**
     * Get the value of player's hand
     * @return
     */
    public int handValue(){
        return hand.getScore();
    }


    /**
     * Get user's balance
     * @return
     */
    public int getMoney() {
        return money;
    }

    /**
     * Set user's balance
     * @param money
     */
    public void setMoney(int money) {
        this.money = money;

    }

    /**
     * Get user's hand
     * @return
     */

    public Hand getHand(){
        return hand;
    }

    /**
     * Cleaar the player' hand
     */
    public void clearHand() {
        hand.clearHand();
    }

    /**
     * Add the oassed card ot the user's hand
     * @param c
     */
    public void addCardToHand(Card c) {
        hand.addCard(c);
    }


    /**
     * Prompt the player to make a bet
     * @return
     */
    public abstract int makeBet();

    /**
     * Make move
     * @return
     */
    public abstract PlayerMoves makeMove();
}
