package com.morganjohansson.gametest.Controller;



import com.morganjohansson.gametest.Business.Service.GameService;
import com.morganjohansson.gametest.domain.Game;
import com.morganjohansson.gametest.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
/*
* The main restcontroller that handles all the incoming POST/GET requests.
* The game ID is used to join a game, make a move or check game status.
*
*
 */

@Controller
@RequestMapping("/api")
public class GameController {

    @Autowired
    private GameService gameService;


    @GetMapping(path = "/games/{Id}")
    public Game checkGame(@PathVariable String Id){
      return gameService.checkStatus(Id);

    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }



    @RequestMapping(path = "/game", method = RequestMethod.GET)
    public String newGame() {
        return "newGame";

    }

    @CrossOrigin
    @RequestMapping(path = "/games", consumes = "application/json",produces = "application/json", method = RequestMethod.POST)
    public Game newGame(@RequestBody Player player, UriComponentsBuilder builder) {
        System.out.print("accepted the post method");
        Game returnValue = gameService.createGame(player);
        builder.path("/{Id}").buildAndExpand(returnValue.getId());
        return returnValue;

    }



    @PostMapping(path = "/games/{Id}/join")
    public Game joinGame(@RequestBody Player player,@PathVariable String Id){

     return gameService.joinGame(player,Id);

    }




    @PostMapping(path="/games/{Id}/move")
    public Game move(@RequestBody Player player,@PathVariable String Id){

       return gameService.makeMove(player,Id);

    }







}
