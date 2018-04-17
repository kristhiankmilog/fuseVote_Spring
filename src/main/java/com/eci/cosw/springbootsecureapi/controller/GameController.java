package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Game;
import com.eci.cosw.springbootsecureapi.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("searchGame" )
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping( path="/{name}", method = RequestMethod.GET )
    public Game getGames(@PathVariable String name){
        return gameService.getGame(name);
    }

    @RequestMapping( value ="/games", method = RequestMethod.GET )
    public List<Game> topGames(){
        System.out.println(gameService.getTopGame());
        return gameService.getTopGame();
    }

    @RequestMapping(  path="/addComment" ,method = RequestMethod.POST)
    public void addComments(@RequestBody Comment comment){
        gameService.newComment(comment);
    }

    @RequestMapping(path="/saveGame",method = RequestMethod.POST)
    public Game createGame(@RequestBody Game game){
        return gameService.createGame(game);
    }
}