package com.npatta01.blackjack.card;

import java.util.Random;

/**
 * Created by Nidhin on 7/20/2014.
 */
public class Deck {



    private Card [] cards;

    private int currentIndex;
    private final int SIZE_OF_DECK=52;

    public Deck(){
        cards= new Card[SIZE_OF_DECK];

        int i=0;
        for (Suite s : Suite.values()){
            for (Rank v: Rank.values()){
                cards[i]=new Card(s,v);
                i++;
            }
        }

        currentIndex=0;
    }

    public void shuffle(){
        currentIndex=0;
        Random rnd = new Random();
        for (int i = cards.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card c = cards[index];
            cards[index] = cards[i];
            cards[i] = c;
        }
    }

    public Card deal() throws ArrayIndexOutOfBoundsException {
        if (currentIndex >=SIZE_OF_DECK ){
            throw new ArrayIndexOutOfBoundsException("Reaced End of deck");
        }
        Card c= cards[currentIndex];

        currentIndex++;
        return c;

    }



}
