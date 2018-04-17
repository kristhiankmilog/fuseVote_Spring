package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.Game;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query("from Game as g WHERE g.name=?1")
    List<Game> game(String name);
   /* @Query("from Game as g ")
    List<Game> top();*/
  /*  @Query("SELECT * FROM Game g")
    List<Seller> sellers();*/

}