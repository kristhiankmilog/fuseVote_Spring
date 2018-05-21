package com.eci.cosw.springbootsecureapi.service;


import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.model.Change;

import java.util.List;

/**
 * @author kristhian gomez
 * 17/5/18.
 */
public interface UserService
{
    List<User> getUsers();

    User getUser( long l );

    User createUser( User user );

    User findUserByEmail( String email );

    User findUserById( Integer id );

    User findUserByEmailAndPassword( String email, String password );

    User RegisterUser (User user);

    List<Change> getChangeList(String email);
    
    List<Change> getAllChanges(String email);

    Change addChange(Change change,String email);

    
}