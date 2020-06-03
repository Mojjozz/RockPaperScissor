package com.rps.gametest.Business.Service;




import com.rps.gametest.Business.Enums.Rules;
import com.rps.gametest.Business.Exceptions.*;
import com.rps.gametest.domain.Game;
import com.rps.gametest.domain.Player;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;


/*
* GameService class that handles all the information from the game controller.
* The class names should be self-explanatory
* A hashmap is used to store the games in memory.
* Gamestatus:
*   0, Game created, waiting for players.
*   1, waiting for players to make moves.
*   2 -> Game over, check winner.
*
*
 */



@Service
public class GameService {

    private HashMap<String, Game> gamemap = new HashMap<String, Game>();





    public Game createGame(Player player) {
        Game game = new Game(player);
        UUID uuid = UUID.randomUUID();
        game.setId(uuid.toString());
        game.setGameMessage("GAME CREATED, WAITING FOR PLAYER 2");
        game.setGameStatus(0);
        gamemap.put(game.getId(), game);
        return new Game(uuid.toString(),player.getName(),game.getGameMessage());
    }




    public Game joinGame(Player player, String Id) {
            Game game = validateGame(Id);
            if(game.isFull(game)) throw new GameFullException(Id);
            if(game.isPlayer(player.getName())) throw new NameAlreadyInUse(player.getName());
            game.addPlayer(player);
            game.setGameMessage(String.format("PLAYER2 %s JOINED, WAITING FOR MOVES",player.getName()));
            game.setGameStatus(1);
            return new Game(game.getId(),player.getName(),game.getGameMessage());
        }




    public Game makeMove(Player player, String Id) {
        Game game = validateGame(Id);
        validateMove(player.getMove());
        if(!game.isFull(game)) throw new WaitingForPlayerException(Id);
        if(!game.movesLeft(game)) throw new NoMoreMovesException(Id);

        if (game.isPlayer(player.getName())) {
            game.setP1Move(player.getMove());
        } else {
            game.setP2Move(player.getMove());
        }

        if (!game.movesLeft(game)) {
            game.setGameMessage("BOTH PLAYERS HAVE MADE MOVES, CHECK GAME WINNER");
            game.setGameStatus(2);
        }

        return new Game(game.getId(), player.getName(), game.getGameMessage(), player.getMove());
    }





    public Game checkStatus(String Id) {
        Game game = validateGame(Id);
        return game.gameState(game);
    }




    public void validateMove(String move){
        try{
            Rules.valueOf(move.toUpperCase());
            }catch (IllegalArgumentException e) {
            throw new UnvalidMoveException(move);
        }
    }





    public Game validateGame(String Id){
        if (gamemap.containsKey(Id)) {
            Game game = gamemap.get(Id);
            return game;
        }else{
            throw new GameNotFoundException(Id);
        }
    }
}


