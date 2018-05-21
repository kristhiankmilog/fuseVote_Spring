package com.eci.cosw.springbootsecureapi.repositories;


import com.eci.cosw.springbootsecureapi.model.Change;
import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;



public interface UserRepository extends JpaRepository <User,Integer>{



    @Query(value ="select * from user u where u.email = ?1", nativeQuery = true)
    User findUserByEmail(String email);

    @Query(value ="select * from user u where u.id = ?1", nativeQuery = true)
    User findUserById(int id);

    @Query(value ="select * from user_vote u where u.email = ?1 and u.password = ?2", nativeQuery = true)
    User findUserByEmailAndPassword(String email, String password);


    


}




