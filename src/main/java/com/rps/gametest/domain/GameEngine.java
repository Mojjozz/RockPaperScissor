package com.rps.gametest.domain;


/*
* The main game engine that decides the result of the game.
* The result draw is returned if the players have chosen the same move.
* Rules is used to decide which move that beats the other
* move1 is the move of player1
* move2 is the move of player2
 */


import com.rps.gametest.Business.Enums.Rules;

public class GameEngine {


    public static int winner(String m1, String m2) {


        String M1 = m1.toUpperCase();
        String M2 = m2.toUpperCase();
        if(M1.equals(M2)) return 0;
        Rules move1 = Rules.valueOf(M1);
        Rules move2 = Rules.valueOf(M2);


        if(move1.beats(move2)){
            return 1;
        }else{
            return 2;
        }



    }

}
