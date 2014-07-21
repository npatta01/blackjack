package com.npatta01.blackjack.io;

import com.npatta01.blackjack.player.PlayerMoves;
import com.npatta01.blackjack.card.Hand;

/**
 * Displays game state to the user
 */
public interface IDisplay {

    /**
     * Show starting message of the game
     * @param message
     */
    public void showGameMessage(String message);

    /**
     * Show the game rules
     * @param message
     */
    public void showGameRules(String message);

    /**
     * Display info about start of round
     * @param roundNumber current round
     * @param playerMoney user's money
     * @param dealerMoney dealer's money
     */
    public void roundStartingInfo(int roundNumber, int playerMoney, int dealerMoney);

    /**
     * Display the Bets of the user and dealer
     * @param playerBet
     * @param dealerBet
     */
    public void displayBets(int playerBet, int dealerBet);

    /**
     * Display the hand of the passed player
     * @param player
     * @param h
     */
    public void displayHand(String player, Hand h);

    /**
     * Display the dealer of the move made by dealer
     * @param p
     */
    public void informOfDealerMove(PlayerMoves p);

    /**
     * Inform who won hte current round
     * @param user
     */
    void informRoundWinner(String user);


    /**
     * Infrom who won the game
     * @param winner
     */
    void informGameEnded(String winner);
}
