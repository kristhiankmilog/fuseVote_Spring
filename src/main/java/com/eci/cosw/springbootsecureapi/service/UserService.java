package com.eci.cosw.springbootsecureapi.service;
import com.eci.cosw.springbootsecureapi.model.Exrequests;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.model.Change;

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

    List<Change> getChangeList(String email);
    
    List<Change> getAllChanges(String email);

    Change addChange(Change change,String email);

    Exrequests addRequests(Exrequests requests,String email);
    
    List<Exrequests> getAllRequests(String email);
}