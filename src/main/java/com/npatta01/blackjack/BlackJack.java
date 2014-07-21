package com.npatta01.blackjack;

import com.npatta01.blackjack.card.Deck;
import com.npatta01.blackjack.io.IDisplay;
import com.npatta01.blackjack.player.Dealer;
import com.npatta01.blackjack.player.GameState;
import com.npatta01.blackjack.player.HumanPlayer;
import com.npatta01.blackjack.player.PlayerMoves;

/**
 * A Blackjack game
 */
public class BlackJack {


    private final String welcomeMessage="Welcome to Blackjack";
    private final String rules="Try to get as close to 21\n You can hit and stand\n Minimum bet is 1\n";

    //player and dealer
    private HumanPlayer player;
    private Dealer dealer;

    //current round
    private int round;
    //deck
    private Deck deck;

    //display for output
    private IDisplay display;

    //current game state
    private GameState gamestate;
    //starting coins for users
    private final int startingAmount = 100;

    /**
     * Construtor
     * @param outputer
     * @param player
     * @param dealer
     * @param d
     */
    public BlackJack(IDisplay outputer, HumanPlayer player, Dealer dealer, Deck d){

        this.display =outputer;
        this.player=player;
        this.dealer=dealer;
        this.deck=d;
        round=0;
    }

    /**
     * Start the game
     *  Show the rules and sets user's balance
     */
    public void startGame(){
        display.showGameMessage(welcomeMessage);
        display.showGameRules(rules);

        player.setMoney(startingAmount);
        dealer.setMoney(startingAmount);
        gamestate=GameState.ROUND_STARTED;

    }


    /**
     * Game is over when the dealer or player is out of money
     * @return
     */
    public boolean gameOver(){
        return gamestate==GameState.DEALER_WON_GAME || gamestate==GameState.PLAYER_WON_GAME;
    }


    /**
     * A round of blackjack
     */
    public void playRound(){
        round++;
        if(!gameOver()){
            deck.shuffle();//shuffle deck at start of each round
            //empty user's hand
            player.clearHand();
            dealer.clearHand();

            //dispaly info that ha round has started
            gamestate=GameState.ROUND_STARTED;
            display.roundStartingInfo(round, player.getMoney(), dealer.getMoney());


            //ask player to make bet
            int pBet=player.makeBet();
            //ask dealer to make bet
            int dBet=dealer.makeBet();

            //display bets made by both players
            display.displayBets(pBet, dBet);

            //deal two cards altrnatingly cards
            player.addCardToHand(deck.deal());
            dealer.addCardToHand(deck.deal());
            player.addCardToHand(deck.deal());
            dealer.addCardToHand(deck.deal());

            display.displayHand("player", player.getHand());


            //ask player to make move
            while(player.handValue()<=21 && player.makeMove()!= PlayerMoves.STAND  ){
                player.addCardToHand(deck.deal());
                display.displayHand("player", player.getHand());
            }

           //ask dealer to make Move
           while(dealer.handValue()<=21 && dealer.makeMove()!=PlayerMoves.STAND ){
               dealer.addCardToHand(deck.deal());
               display.informOfDealerMove(PlayerMoves.HIT);

           }
            display.informOfDealerMove(PlayerMoves.STAND);

            //dsiplay dealer's hand
            display.displayHand("dealer", dealer.getHand());



            //decide winner
            if (player.handValue()>21) {
                if (dealer.handValue() > 21) {//both lost
                    gamestate=GameState.BOTH_LOST_ROUND;
                } else {//dealer won
                    gamestate=GameState.DEALER_WON_ROUND;
                }
            }else {
                if (player.handValue()>dealer.handValue()) {//player won
                    gamestate=GameState.PLAYER_WON_ROUND;
                }else if (player.handValue()<dealer.handValue() && dealer.handValue()<=21){//dealer won
                    gamestate=GameState.DEALER_WON_ROUND;
                }else{
                    gamestate=GameState.TIE;
                }
            }

            //update winnings
             if (gamestate==GameState.PLAYER_WON_ROUND){

                    display.informRoundWinner("player");
                 player.setMoney(player.getMoney()+pBet+dBet);
             }else if (gamestate==GameState.DEALER_WON_ROUND){
                 dealer.setMoney(dealer.getMoney()+pBet+dBet);
                 display.informRoundWinner("dealer");
             }else {
                 dealer.setMoney(dealer.getMoney()+dBet);
                 player.setMoney(player.getMoney()+pBet);
                 display.informRoundWinner("No One");
             }

            //check if any player is out of money
            if(player.getMoney()<1){
                gamestate=GameState.DEALER_WON_GAME;
                display.informGameEnded("dealer");
            }else if (dealer.getMoney()<1){
                gamestate=GameState.PLAYER_WON_GAME;
                display.informGameEnded("player");
            }


        }

    }


}
