package com.npatta01.blackjack.io;

import com.npatta01.blackjack.player.PlayerMoves;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Reads user input form the conosle
 */
public class ConsoleReader implements IReader {


    @Override
    public PlayerMoves getMove() {
        boolean validOptionRead=false;
        PlayerMoves pm = null;

        while(!validOptionRead){//prompt the user to hit or stand
            try {
                System.out.println("Hit(h) or Stand (s): ");
                BufferedReader is = new BufferedReader(
                        new InputStreamReader(System.in));
                String readOption = is.readLine();

                if (readOption.equals("h")){
                    pm= PlayerMoves.HIT;
                    validOptionRead=true;
                }else  if (readOption.equals("s")){
                    pm= PlayerMoves.STAND;
                    validOptionRead=true;
                }


            }catch(Exception e){

            }
        }
        return pm;
    }


    @Override
    public int getBet(int minBet,int maxBet) {

        boolean valid =false;
        int bet;
        while (!valid){//exit only when valid inout parsed
            try {
                System.out.printf("Enter Bet Amount between 1 and %d:%n", maxBet);
                BufferedReader is = new BufferedReader(
                        new InputStreamReader(System.in));
                bet = Integer.parseInt(is.readLine());

                if (bet>=minBet && bet <=maxBet){
                    valid=true;
                   return bet;
                }

            }catch (Exception e){

            }
        }

        return 0;
    }
}
