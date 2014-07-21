package com.npatta01.blackjack.steps;

import com.npatta01.blackjack.*;
import com.npatta01.blackjack.card.Card;
import com.npatta01.blackjack.card.Hand;
import com.npatta01.blackjack.io.IDisplay;
import com.npatta01.blackjack.io.IReader;
import com.npatta01.blackjack.player.Dealer;
import com.npatta01.blackjack.player.HumanPlayer;

import java.util.List;

/**
 * Created by Nidhin on 7/21/2014.
 */
public class HelperObject {


    public BlackJack blackjack;
    public IDisplay output;
    public HumanPlayer player;
    public Dealer dealer;
    public FakeDeck deck;
    public List<Card> cards;
    public Hand phand;
    public Hand dhand;
    public Hand intersetedHand;
    public IReader reader;

}
