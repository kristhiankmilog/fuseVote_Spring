package com.eci.cosw.springbootsecureapi.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;

import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.model.Change;
import com.eci.cosw.springbootsecureapi.model.Exrequests;
import com.eci.cosw.springbootsecureapi.service.ServicesException;
import com.eci.cosw.springbootsecureapi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @CrossOrigin
    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public User setTodo(@RequestBody User user) {
        return userService.RegisterUser(user);

    }

    @CrossOrigin
    @RequestMapping(value = "/{email}", method = RequestMethod.GET)

    public User getUsersByEmail(@PathVariable("email") String email) {
        return userService.findUserByEmail(email);
    }

    @CrossOrigin
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)

    public User getUsersById(@PathVariable("id") int id) {

        System.out.println("Id: " + id);

        return userService.findUserById(id);

    }

    @CrossOrigin
    @RequestMapping( value = "/", method = RequestMethod.POST )

    public User setUsers(@RequestBody User user) throws ServicesException {

        if(user.getUsername()==null || user.getUsername().trim().isEmpty()){

            throw new ServicesException("Please fill in name");

        }

        else if(user.getEmail()==null || user.getEmail().trim().isEmpty()){

            throw new ServicesException("Please fill in email");

        }

        else if(userService.findUserByEmail(user.getEmail())!=null){

            throw  new ServicesException("Email alredy registered. Please try again.");

        }

        else if(user.getPassword()==null || user.getPassword().trim().isEmpty()){

            throw new ServicesException("Please fill in password");

        }


        else{

            return userService.createUser(user);

        }

    }

    @CrossOrigin
    @RequestMapping(value = "/updateprofile/{id}", method = RequestMethod.POST)

    public User updateUser(@RequestBody User updateuser, @PathVariable("id") int id) throws ServicesException {

        User u = userService.findUserById(id);

        if (!updateuser.getEmail().trim().equals(u.getEmail())
                && userService.findUserByEmail(updateuser.getEmail()) != null) {

            throw new ServicesException("Email alredy registered. Please try again.");

        } else {

            return userService.updateUser(updateuser, u);

        }

    }

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Token login(@RequestBody User login) throws ServletException {

        String jwtToken = "";

        if (login.getEmail() == null || login.getPassword() == null) {
            System.out.println(getUsersByEmail(login.getEmail()));
            throw new ServletException("Please fill in email and password");
        }

        String username = login.getEmail();
        String password = login.getPassword();

        User user = userService.findUserByEmailAndPassword(username, password);

        if (user == null) {
            throw new ServletException("User email not found.");
        }

        String pwd = user.getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your email and password.");
        }

        jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        return new Token(jwtToken);
    }

    public class Token {

        String access_token;

        public Token(String access_token) {
            this.access_token = access_token;
        }

        public String getAccessToken() {
            return access_token;
        }

        public void setAccessToken(String access_token) {
            this.access_token = access_token;
        }
    }


    @CrossOrigin
    @RequestMapping( value = "/changes/{email}", method = RequestMethod.GET )
    public List<Change> getChangeList(@PathVariable(name = "email") String email){
        return userService.getChangeList(email);
    }

    @CrossOrigin
    @RequestMapping( value = "/changes/{email}", method = RequestMethod.POST )
    public Change setChange(@RequestBody Change change, @PathVariable(name = "email") String email){
        return userService.addChange(change,email);
    }

    @CrossOrigin
    @RequestMapping( value = "/exchanges/{email}", method = RequestMethod.GET )
    public List<Change> getAllChanges(@PathVariable(name = "email") String email){
        return userService.getAllChanges(email);
    }

    @CrossOrigin
    @RequestMapping( value = "/exrequests/{email}", method = RequestMethod.GET )
    public List<Exrequests> getAllExrequests(@PathVariable(name = "email") String email){
        System.out.println("----------------------hace solicitud----------------------");
        return userService.getAllExrequests(email);
    }

    @CrossOrigin
    @RequestMapping( value = "/exrequests/{email}", method = RequestMethod.POST )
    public Exrequests setExrecuest(@RequestBody Exrequests requestis, @PathVariable(name = "email") String email){
        System.out.println("----------------------hace solicitud****************************");
        return userService.addExrequests(requestis,email);
    }


}