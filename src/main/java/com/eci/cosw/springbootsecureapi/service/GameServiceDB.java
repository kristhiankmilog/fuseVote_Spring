  package com.eci.cosw.springbootsecureapi.service;

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
        //  List<Game> games= new ArrayList<Seller>();
         /* for(int i=0;i<=2;i++){
              Game g=gameRepository.getOne(i);
              games.add(g);

          }return
*/
         return gameRepository.findAll();
      }

     // @Override
      public void newComment(Game game1, String comment, String user, int id, int rate) {

      }
  }
