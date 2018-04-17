  package com.eci.cosw.springbootsecureapi.service;

  import com.eci.cosw.springbootsecureapi.model.Comment;
  import com.eci.cosw.springbootsecureapi.model.Game;
  import com.eci.cosw.springbootsecureapi.repositories.CommentRepository;
  import com.eci.cosw.springbootsecureapi.repositories.GameRepository;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;

  import java.util.List;

  @Service
  public class GameServiceDB implements GameService {

      @Autowired
      private GameRepository gameRepository;

      @Autowired
      private CommentRepository cmrepo;

      @Autowired
      private UserService userService;

      public List<Game> getAllGame() {
          return gameRepository.findAll();
      }

      @Override
      public Game getGame(String name) {
         return gameRepository.game(name);
      }

      @Override
      public List<Game> getTopGame() {
         return gameRepository.findAll();
      }

      @Override
      public void newComment(Comment comment) {
          cmrepo.saveAndFlush(comment);
      }

      @Override
      public Game createGame(Game game) {
          return gameRepository.saveAndFlush(game);
      }
  }
