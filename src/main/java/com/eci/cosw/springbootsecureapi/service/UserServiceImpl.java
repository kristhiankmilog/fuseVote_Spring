package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @Autowired
    public UserServiceImpl() {
        users.add(new User(1,"prueba@mail.com","password","Maria Paula","Pinzon","Mape","https://scontent.fbog3-1.fna.fbcdn.net/v/t1.0-9/18699818_10212427754544303_6690553113314510848_n.jpg?oh=2045634da1446089333c804ca41eb98c&oe=5B0C6D78","Student"));

        users.add(new User(2,"prueba2@mail.com","password","Camilo","Garcia","Souls","https://scontent.fbog3-1.fna.fbcdn.net/v/t1.0-9/15826909_10212344692311984_5991376075375360383_n.jpg?oh=eeea7771d5ca2b2f677b002879caaa69&oe=5B18D977","Student and Gamer"));
    }

    @PostConstruct

    private void populateSampleData()

    {

        users.add(0, new User("test@mail.com", "password", "Andres", "Perez",
                "http://farm6.static.flickr.com/5178/5428759578_d6fb2288a4.jpg"));

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

    public User updateUser(User user, User u) {

        u.setImage(user.getImage());

        u.setPassword(user.getPassword());

        u.setEmail(user.getEmail());

        u.setFirstname(user.getFirstname());
        return u;

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

            if (users.get(i).getEmail().trim().equalsIgnoreCase(email)
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

}
