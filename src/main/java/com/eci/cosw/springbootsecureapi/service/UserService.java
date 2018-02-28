package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;

import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
public interface UserService
{
    List<User> getUsers();

    User getUser( long l );

    User createUser( User user );
    public User updateUser(User user,User u);

    User findUserByEmail( String email );

    User findUserById( Integer id );

    User findUserByEmailAndPassword( String email, String password );

    User RegisterUser (User user);
}