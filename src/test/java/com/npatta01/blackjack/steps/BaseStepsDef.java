package com.npatta01.blackjack.steps;

import com.npatta01.blackjack.*;
import com.npatta01.blackjack.card.Hand;
import com.npatta01.blackjack.io.ConsoleReader;
import com.npatta01.blackjack.io.IDisplay;
import com.npatta01.blackjack.io.IReader;
import com.npatta01.blackjack.player.Dealer;
import com.npatta01.blackjack.player.HumanPlayer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Nidhin on 7/20/2014.
 */

public class BaseStepsDef {

    @Autowired
    HelperObject obj;


    @Before
    public void before(){
        obj.output=mock(IDisplay.class);
        obj.player = new HumanPlayer(new Hand(),mock(ConsoleReader.class));
        obj.dealer = new Dealer(new Hand());
        obj.deck=new FakeDeck();
        obj.blackjack = new BlackJack(obj.output,obj.player,obj.dealer,obj.deck);
        obj.reader = mock(IReader.class);
    }

    @After
    public void after(){
        obj.output=null;
        obj.blackjack = null;
    }

    @Given("^I just opened the app$")
    public void startapp(){

        obj.blackjack.startGame();

 

    }
    @Then("I should see a welcome message")
    public void verifyWelcomeMessage(){
        verify(obj.output).showGameMessage(anyString());
    }

    @Then("I should see the Rules")
    public void verifyRulesMessage(){
        verify(obj.output).showGameRules(anyString());
    }

    @And("both players should have (\\d+) coins")
    public void verifyStartingAmount(int coins){
        Assert.assertEquals(obj.player.getMoney(),coins);
        Assert.assertEquals(obj.dealer.getMoney(),coins);


    }
}
