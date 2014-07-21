package com.npatta01.blackjack.card;

import java.util.NoSuchElementException;


/**
 * Suite of a Card (Hearts, Diamonds, Clubs, Spades)
 */
public enum Suite {

    HEARTS("Hearts"),DIAMONDS("Diamonds"),CLUBS("Clubs"),SPADES("Spades");

    /**
     * Cosntrucotr
     * @param representation
     */
    private Suite(String representation){
        this.representation=representation;
    }

    //String represetnation
    private String representation;

    /**
     * Get String value
     * @return
     */
    public String getStringRepresentation(){
        return representation;


    }

    /**
     * Given a string represetnation of a suite, return the Suite
     * @param representation
     * @return
     */
    public static Suite fromString(String representation){
        for (Suite s: Suite.values()){

            if (s.getStringRepresentation().equals(representation)){
                return s;
            }
        }
        throw new NoSuchElementException("Not a valid suite");
    }
}
