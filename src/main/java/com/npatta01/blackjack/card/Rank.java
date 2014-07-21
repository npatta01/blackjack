package com.npatta01.blackjack.card;

import java.util.NoSuchElementException;

public enum Rank {

    ACE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(11),QUEEN(12),KING(13);

    //card Rank
    private int value;

    private Rank(int value) {
        this.value=value;
    }

    /***
     * Get Value of card in blackjack
     * Return the highest values for Ace
     * @return
     */
    public int getCardValue() {

        if (value>10){
            return 10;
        }
        return value;

    }

    /**
     * Get String reprsetnation of card rank
     * @param value
     * @return
     */
    public static Rank fromString(String value){

        switch (value){
            case "Ace":
                return ACE;
            case "Jack":
                return JACK;
            case "King":
                return KING;
            case "Queen":
                return QUEEN;
            case "2":
                return TWO;
            case "3":
                return THREE;
            case "4":
                return FOUR;
            case "5":
                return FIVE;
            case "6":
                return SIX;
            case "7":
                return SEVEN;
            case "8":
                return EIGHT;
            case "9":
                return NINE;
            case "10":
                return TEN;
            default:
                throw new NoSuchElementException("no such element");

        }


    }




}
