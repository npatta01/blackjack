package com.npatta01.blackjack.player;

import com.npatta01.blackjack.card.Hand;

/**
 * A player that represents a dealer.
 * It hits fro a untill it reaches 17
 * It makes a minimum bet of 10 if possig;w
 *
 */
public class Dealer extends BasePlayer {


    private final int OKAY_HAND = 17;
    public Dealer(Hand hand) {
        super(hand);
    }

    /**
     * {@inheritDoc}
     * Always hit, if the card value is 17, else stand
     *
     * @return
     */
    @Override
    public PlayerMoves makeMove(){

        if(hand.getScore()< OKAY_HAND){
            return PlayerMoves.HIT;
        }
        return PlayerMoves.STAND;

    }

    /**
     * @{inheritDoc}
     * Deealer makes a bet of 10 if they can, else make a bet of 1
     * @return
     */
    @Override
    public int makeBet(){
        int bet=1;

        if (money>1){
          bet= Math.min(10,money);
        }

        money=money-bet;
        return bet;

    }
}
