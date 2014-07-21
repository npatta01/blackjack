package com.npatta01.blackjack.steps;

import com.npatta01.blackjack.card.Card;
import com.npatta01.blackjack.card.Deck;

import java.util.List;

/**
 * Created by Nidhin on 7/21/2014.
 */
public class FakeDeck extends Deck {

    private int current;
    private List<Card> cards;


    public void setCards(List<Card> cards){
        this.cards=cards;
        current=0;
    }

    @Override
    public Card deal(){
        int c=current;
        current++;
        return cards.get(c);
    }
}
