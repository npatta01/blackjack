package com.npatta01.blackjack.card;

/**
 * Representation of a card
 */
public class Card {



    //rank of a Card
    private Rank value;
    //suite of a card
    private Suite suite;

    /**
     * Crete a caard with sepecific suite and rank
     * @param suite
     * @param value
     */
    public Card(Suite suite,Rank value){
        this.suite=suite;
        this.value=value;
    }


    /**
     * Create a card from the striing represetnation oda rank and suite
     * @param suite
     * @param cardValue
     * @return
     */
    public static Card creteFromString(String suite,String cardValue){
        Suite s= Suite.fromString(suite);
        Rank v = Rank.valueOf(cardValue);
        return new Card(s,v);

    }

    /**
     * Get card value of a card .
     * J,K,Q return 10
     * Ace returns 11
     * @return
     */
    public int getCardValue(){
        return value.getCardValue();
    }

    /**
     * Get Rank
     * @return
     */
    public Rank getRank(){
        return value;
    }

    /**
     * Get Suite
     * @return
     */
    public Suite getSuite(){
        return suite;
    }


    @Override
    public String toString(){
        return String.format("%s %d", suite.getStringRepresentation(), value.getCardValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suite != card.suite) return false;
        if (value != card.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + suite.hashCode();
        return result;
    }
}


