package com.npatta01.blackjack.io;

import com.npatta01.blackjack.player.PlayerMoves;

/**
 * Utility to prompt the user for input
 */
public interface IReader {

    /**
     * Get the move that hte player would like to make
     * @return
     */
    public PlayerMoves getMove();

    /**
     * Prompt the user for a bet within the range.
     * @param minBet
     * @param maxBet
     * @return
     */
    public int getBet(int minBet, int maxBet);
}
