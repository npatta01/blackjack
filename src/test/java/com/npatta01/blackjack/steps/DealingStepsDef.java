package com.npatta01.blackjack.steps;

import com.npatta01.blackjack.*;
import com.npatta01.blackjack.card.Card;
import com.npatta01.blackjack.card.Hand;
import com.npatta01.blackjack.io.ConsoleReader;
import com.npatta01.blackjack.io.IDisplay;
import com.npatta01.blackjack.io.IReader;
import com.npatta01.blackjack.player.Dealer;
import com.npatta01.blackjack.player.HumanPlayer;
import com.npatta01.blackjack.player.PlayerMoves;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by Nidhin on 7/20/2014.
 */
public class DealingStepsDef {

    private BlackJack blackjack;
    private IDisplay output;
    private HumanPlayer player;
    private Dealer dealer;
    private FakeDeck deck;
    private List<Card> cards;
    private Hand phand;
    private Hand dhand;
    private Hand intersetedHand;
    private IReader reader;


    @Autowired
    HelperObject obj;

    @Before
    public void before(){
        output=mock(IDisplay.class);
        phand = new Hand();
        dhand = new Hand();
        reader=mock(ConsoleReader.class);
        player = new HumanPlayer(phand,reader);
        dealer = spy(new Dealer(dhand));
        deck=new FakeDeck();
        blackjack = new BlackJack(output,player,dealer,deck);
        cards= new LinkedList<Card>();

    }

    @After
    public void after(){
        output=null;
        blackjack = null;
    }
    @Given("a new round")
    public void newDeck(){



    }



    @And("the following next cards in the deck:")
    public void addCardsToDeck(List<String> expectedCards){

        for (String s: expectedCards){
            Card c=HandStepDefs.parseCardFromstring(s);
            cards.add(c);

        }

        deck.setCards(cards);
        //when(deck.deal()).thenReturn(cards.get(0),cards.get(1),cards.get(2),cards.get(3),cards.get(4));

    }


    @When("the round starts")
    public void startGame(){
        blackjack.startGame();

    }


    @And("the player chooses to (.+)")
    public void setPlayerMove(String move){

        if (move.equals("hit")){
            when(reader.getMove()).thenReturn(PlayerMoves.HIT,PlayerMoves.STAND);

        }else{
            when(reader.getMove()).thenReturn(PlayerMoves.STAND);
        }
        when(dealer.makeMove()).thenReturn(PlayerMoves.STAND);
        blackjack.playRound();
    }

    @And("player should have the following cards:")
    public void verifyCardsInHand2(List<String> cards){
        intersetedHand=phand;
        verifyHand(cards);

    }

    @Then("dealer should have the following cards:")
    public void verifyCardsInHand(List<String> cards){
        intersetedHand=dhand;

        verifyHand(cards);




    }


    private void verifyHand(List<String> cards){
        Hand toCheck = new Hand();
        for (String s: cards){
            Card c=HandStepDefs.parseCardFromstring(s);
            toCheck.addCard(c);
        }



        Assert.assertEquals(intersetedHand, toCheck);
    }


}
