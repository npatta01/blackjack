package com.npatta01.blackjack.io;

import com.npatta01.blackjack.player.PlayerMoves;
import com.npatta01.blackjack.card.Hand;

/**
 * Dispalys game state in the console
 */
public class ConsoleDisplay implements IDisplay {


    @Override
    public void showGameMessage(String message) {
        System.out.println(message);
    }

    public void showGameRules(String message){
        System.out.println(message);
    }

    @Override
    public void roundStartingInfo(int roundNumber, int playerMoney, int dealerMoney) {
        System.out.println();
        System.out.println("Round "+roundNumber);
        System.out.println("Player Money:"+playerMoney);
        System.out.println("Dealer Money:"+dealerMoney);
    }

    @Override
    public void displayBets(int playerBet, int dealerBet) {
        System.out.println("Player Bet:"+playerBet);
        System.out.println("Dealer Bet:"+dealerBet);
    }

    @Override
    public void displayHand(String player, Hand h) {
        System.out.printf("%s: Score:%d%n", player, h.getScore());
        System.out.println(h.getCards());
        System.out.println();
    }

    @Override
    public void informOfDealerMove(PlayerMoves p) {
        if (p==PlayerMoves.HIT){
            System.out.println("Dealer Hit");
        }else  if (p==PlayerMoves.STAND){
            System.out.println("Dealer Stand");
        }
    }

    @Override
    public void informRoundWinner(String user){
        System.out.println(user+ " Won");
    }
    @Override
    public void informGameEnded(String winner){
        System.out.println(winner+" Won the game");
    }
}
