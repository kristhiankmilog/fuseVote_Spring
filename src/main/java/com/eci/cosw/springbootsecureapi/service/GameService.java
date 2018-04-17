package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Game;

import java.util.List;

public interface GameService {
    Game getGame(String name);
    List<Game> getTopGame();
    Game createGame(Game game);
    void newComment(Comment comment);
}
