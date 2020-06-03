package com.morganjohansson.gametest.domain;

/*
* Game object: holds 2 player objects, id, gamemessage and gamestatus.
 */

public class Game{
    private String Id;
    private String gameMessage;
    private int gameStatus;
    private String name;
    private Player p1;
    private Player p2;
    private String move;


    public Game(Player p1){
       this.p1 = new Player(p1.getName());

    }
    public Game(String Id, String gameMessage){
        this.Id = Id;
        this.gameMessage = gameMessage;
    }

    public Game(String Id, String name, String gameMessage){
        this.Id = Id;
        this.name = name;
        this.gameMessage = gameMessage;
    }
    public Game(String Id, String name, String gameMessage, String move){
        this.Id = Id;
        this.name = name;
        this.gameMessage = gameMessage;
        this.move = move;
    }

    public void setGameStatus(int i){

        this.gameStatus = i;
    }

    public void setGameMessage(String message){

        this.gameMessage = message;

    }
    public String getGameMessage(){

        return gameMessage;
    }
    public String getId() {

        return Id;
    }

    public void setId(String Id) {

        this.Id = Id;
    }

    public String getMove(){

        return move;
    }

    public String getName(){

        return name;
    }

    public void setP1Move(String move){

        p1.setMove(move);
    }

    public void setP2Move(String move){

        p2.setMove(move);
    }


    public void addPlayer(Player player) {

        this.p2 = new Player(player.getName());
    }


    public boolean isPlayer1(String name){

        return name.equals(p1.getName());
    }

    public boolean isPlayer2(String name){

        return name.equals(p2.getName());
    }


    public boolean movesCompleted(){
        if(p1.getMove()==null){
            setGameMessage(String.format("%s HAVE NOT MADE A MOVE",p1.getName()));
            return false;
        }else if(p2.getMove()==null){
            setGameMessage(String.format("%s HAVE NOT MADE A MOVE",p2.getName()));
            return false;
        }
        else{
            return true;
        }
    }



    public boolean isFull(){
        if(gameStatus==0){
            return false;
        }else{
            return true;
        }
    }



    public Game gameState(){
        switch (gameStatus){
            case 0:{
                setGameMessage("Waiting for second player");
                return new Game(getId(),getGameMessage());
            }
            case 1:{
                setGameMessage("Waiting for player moves");
                return new Game(getId(),getGameMessage());
            }
            case 2:{
                int win = checkWinner(p1.getMove(),p2.getMove());
                if(win == 1){
                    setGameMessage("Player1 won");
                    return new Game(getId(),p1.getName(),getGameMessage(),p1.getMove());
                }else if(win==2){
                    setGameMessage("Player2 won");
                    return new Game(getId(),p2.getName(),getGameMessage(),p2.getMove());
                }else{
                    setGameMessage("It is a draw!");
                    return new Game(getId(),getGameMessage());
                }
            }
            default:{
                setGameMessage("OPS SOMETHING WENT WRONG");
                return new Game(getId(),getGameMessage());
            }
        }

    }


    private int checkWinner(String move, String move1) {
        int Winner = GameEngine.winner(move,move1);
        if(Winner==1) return 1;
        if(Winner==2) return 2;
        return 0;

    }


}
