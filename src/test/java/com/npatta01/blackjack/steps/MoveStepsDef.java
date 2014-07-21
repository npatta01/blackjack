package com.npatta01.blackjack.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by Nidhin on 7/21/2014.
 */
public class MoveStepsDef {


    @Autowired
    HelperObject obj;

    @When("the (.+) has (.+) coins")
    public void updateMoney(String user, int coins){
        obj.dealer.setMoney(100);
        obj.player.setMoney(100);
    }

    @And("the (.+) makes a bet of (.+)")
    public void makeUserBet(String user,int bet){
        if (user.equals("player")){
            when(obj.reader.getBet(anyInt(),anyInt())).thenReturn(bet);
        }else{
            //when(obj.dealer.makeBet()).thenReturn(bet);
        }
    }

    @When("the round is over")
    public void makeRound(){
        obj.blackjack.playRound();
    }

    @When("the (.+) should have  (.+) coins")
    public void verifyMoney(String user, int coins){
        obj.dealer.getMoney();
        if (user=="player"){
            Assert.assertEquals(obj.player.getMoney(),coins);
        }else{
            Assert.assertEquals(obj.dealer.getMoney(),coins);
        }

    }

}
