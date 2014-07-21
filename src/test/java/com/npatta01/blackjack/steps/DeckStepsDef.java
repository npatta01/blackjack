package com.npatta01.blackjack.steps;

import com.npatta01.blackjack.card.Card;
import com.npatta01.blackjack.card.Deck;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by Nidhin on 7/20/2014.
 */
public class DeckStepsDef {



    private Deck deck;


    @Given("a deck of cards")
    public void newDeck(){

        deck = new Deck();

    }


    @When("the deck is shuffled")
    public void shuffleDeck(){
        deck.shuffle();
    }


    @Then("the order of cards should be changed")
    public void verifyShuffleWorks(){

        Card c1 = null;
        Card c2 = null;
        try {
            c1=deck.deal();
            c2=deck.deal();
        }catch(ArrayIndexOutOfBoundsException ae){
            Assert.fail("Deck is empty");
        }


        Deck other_deck = new Deck();
        other_deck.shuffle();

        Card o1=other_deck.deal();
        Card o2 =other_deck.deal();

        boolean firstCardSame= c1==o1;
        boolean secondCardSame= c2==o2;

        boolean shuffling_works= firstCardSame & secondCardSame;
        Assert.assertEquals(shuffling_works,false);

    }




}
