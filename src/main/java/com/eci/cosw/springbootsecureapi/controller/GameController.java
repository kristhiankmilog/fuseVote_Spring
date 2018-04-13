package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Game;
import com.eci.cosw.springbootsecureapi.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping( value ="/game", method = RequestMethod.GET )
    public List<Game> topGames(){
        System.out.println("hollal");
        return gameService.getTopGame();
    }
    @RequestMapping(  path="/{name}" ,method = RequestMethod.POST)
    public void addComments(@PathVariable String name, @PathVariable String content,@PathVariable String user, @PathVariable int rate,@PathVariable int id){
        Game g=gameService.getGame(name);
        gameService.newComment(g,content,user,id,rate);
    }
}