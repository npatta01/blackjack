package com.npatta01.blackjack.player;

import com.npatta01.blackjack.card.Hand;
import com.npatta01.blackjack.io.IReader;

/**
 * Created by Nidhin on 7/20/2014.
 */
public class HumanPlayer extends BasePlayer {


    private IReader reader;

    public HumanPlayer(Hand hand, IReader reader) {
        super(hand);
        this.reader = reader;


    }


    public int makeBet() {

        int bet = reader.getBet(1, money);
        money = money - bet;
        return bet;


    }

    public PlayerMoves makeMove() {


        return reader.getMove();


    }


}
