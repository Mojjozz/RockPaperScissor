package com.rps.gametest.domain;

/*
* Player object that holds name and move of player.
 */


public class Player {

    private String name;
    private String move;


    public Player(){
        this.name = "";
        this.move = "";


    }

    public Player(String name){
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getMove() {

        return move;
    }

    public void setMove(String move) {

        this.move = move;
    }



}
