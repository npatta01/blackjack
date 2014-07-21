package com.npatta01.blackjack;


import com.npatta01.blackjack.card.Deck;
import com.npatta01.blackjack.card.Hand;
import com.npatta01.blackjack.io.ConsoleDisplay;
import com.npatta01.blackjack.io.ConsoleReader;
import com.npatta01.blackjack.io.IDisplay;
import com.npatta01.blackjack.io.IReader;
import com.npatta01.blackjack.player.Dealer;
import com.npatta01.blackjack.player.HumanPlayer;

/***
 * App Driver for Blackjack
 */
public class App {

    /***
     * Consoel Driver for Blackjack game
     * @param args
     */
    public static void main (String [] args){
        //get a display where output is printed on screen
        IDisplay outputer = new ConsoleDisplay();
        //read user input from stf/in
        IReader reader = new ConsoleReader();
        //initialize human player
        HumanPlayer player=new HumanPlayer(new Hand(),reader);
        //initialize dealer hand
        Dealer dealer = new Dealer(new Hand());
        //initilziae deck
        Deck d= new Deck();

        //initalize the game
        BlackJack b = new BlackJack(outputer,player,dealer,d);

        //start the game
        b.startGame();

        //play rounds of the game until someone wins
        while(!b.gameOver()){
            b.playRound();
        }
    }
}
