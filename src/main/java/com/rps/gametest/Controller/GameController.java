package com.rps.gametest.Controller;



import com.rps.gametest.Business.Service.GameService;
import com.rps.gametest.domain.Game;
import com.rps.gametest.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
/*
* The main restcontroller that handles all the incoming POST/GET requests.
* The game ID is used to join a game, make a move or check game status.
*
*
 */

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    private GameService gameService;

    @CrossOrigin
    @GetMapping(path = "/games/{Id}")
    public Game checkGame(@PathVariable String Id){
      return gameService.checkStatus(Id);

    }



    @CrossOrigin
    @PostMapping(path = "/games", consumes = "application/json",produces = "application/json")
    public Game newGame(@RequestBody Player player, UriComponentsBuilder builder) {
        Game returnValue = gameService.createGame(player);
        builder.path("/{Id}").buildAndExpand(returnValue.getId());
        return returnValue;

    }
    
    
    @CrossOrigin
    @PostMapping(path = "/games/{Id}/join")
    public Game joinGame(@RequestBody Player player,@PathVariable String Id){

     return gameService.joinGame(player,Id);

    }



    @CrossOrigin
    @PostMapping(path="/games/{Id}/move")
    public Game move(@RequestBody Player player,@PathVariable String Id){

       return gameService.makeMove(player,Id);

    }







}
