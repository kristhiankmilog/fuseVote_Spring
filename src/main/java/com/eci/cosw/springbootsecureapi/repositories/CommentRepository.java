package com.eci.cosw.springbootsecureapi.repositories;
import com.eci.cosw.springbootsecureapi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
  /*  @Modifying
    @Query("update Comment as c set c.rate = ?2")
    void editRate(String username, Double rate);
*/

}