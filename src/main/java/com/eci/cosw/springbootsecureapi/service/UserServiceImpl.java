package com.eci.cosw.springbootsecureapi.service;


import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.model.Change;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kristhian gomez
 * 17/5/18.
 */

public class UserServiceImpl implements UserService {


    private List<User> users = new ArrayList<>();

    @Autowired
    public UserServiceImpl() {
        
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        user.setId(users.size());
        return user;
    }


    @Override
    public User findUserByEmail(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().trim().equalsIgnoreCase(email)) {
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public User findUserById(Integer id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return users.get(i);
            }
        }

        return null;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getEmail()+"--------------------------"+email);
            if (users.get(i).getEmail().equalsIgnoreCase(email)
                    && users.get(i).getPassword().trim().equalsIgnoreCase(password)) {
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public User RegisterUser(User user) {
        users.add(user);
        return users.get(users.size() - 1);

    }

    @Override
    public List<Change> getChangeList(String email) {
        User tmp = this.findUserByEmail( email );
        return tmp.getListChange();
    }

    @Override
    public Change addChange(Change change, String email) {
        User tmp = this.findUserByEmail( email );
        tmp.addNewChange(change);
        return tmp.getListChange().get(tmp.getListChange().size() - 1);
    }

    

    @Override
    public List<Change> getAllChanges(String emaile){
        List<Change> tmp = new ArrayList<Change>();
        for (int i = 0; i < this.getUsers().size(); i++) {
            for (int j = 0; j < this.getUsers().get(i).getListChange().size(); j++) {
                System.out.println(this.getUsers().get(i).getListChange().get(j));
                if(this.getUsers().get(i).getEmail() != emaile){
                    tmp.add(this.getUsers().get(i).getListChange().get(j));
                }
            }
        }
        return tmp;
    }

}
