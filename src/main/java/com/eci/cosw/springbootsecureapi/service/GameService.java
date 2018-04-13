package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Game;

import java.util.List;

public interface GameService {
      //  List<Game> getAllGame();

      Game getGame(String name);
     List<Game> getTopGame();
     //   void newSeller(Game game,Seller seller);
     //   List<Game> topGames();
     void newComment(Game game1, String comment, String user, int id, int rate) ;
    }
