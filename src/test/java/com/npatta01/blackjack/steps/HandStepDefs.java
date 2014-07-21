package com.npatta01.blackjack.steps;

import com.npatta01.blackjack.card.Card;
import com.npatta01.blackjack.card.Hand;
import com.npatta01.blackjack.card.Rank;
import com.npatta01.blackjack.card.Suite;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

/**
 * Created by Nidhin on 7/20/2014.
 */
public class HandStepDefs {

    private Hand hand;


    @Given("an empty hand")
    public void createHand(){
        hand=new Hand();
    }


    @And("a card in the hand is (.+)")
    public void addCardtoHand(String card){
        Card c= parseCardFromstring(card);
        if (c!=null){
            hand.addCard(c);
        }


    }

    @Then("the score should be (\\d+)")
    public void validateScore(int score){
        int hand_score=hand.getScore();
        Assert.assertEquals(score,hand_score);

    }


    public static Card parseCardFromstring(String s){
        if (s.equals("None")){
            return null;
        }

        String []values=s.split(" ");
        String suit_rep=values[0];
        String rank_rep=values[1];

        Suite suite= Suite.fromString(suit_rep);
        Rank value= Rank.fromString(rank_rep);

        return new Card(suite,value);

    }




}
