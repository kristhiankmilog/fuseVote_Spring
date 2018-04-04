package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Requests;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.model.Change;
 import com.eci.cosw.springbootsecureapi.repositories.UserRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository usersRepository;


    @Override
    public List<User> getUsers() {
    return usersRepository.findAll();
    }

    @Override
    public User getUser(long l) {
    return null;
    }

    @Override
    public User createUser(User user) {
    return usersRepository.save(user);
    }

    @Override
    public User updateUser(User user, User u) {
    return usersRepository.updateUser(user.getUsername(),user.getEmail(),user.getPassword(),user.getImage(),u.getId());
    }

    @Override
    public User findUserByEmail(String email) {
    return usersRepository.findUserByEmail(email);
    }

    @Override
    public User findUserById(Integer id) {
    return usersRepository.findUserById(id);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
    return usersRepository.findUserByEmailAndPassword(email,password);
    }

    @Override
    public User RegisterUser(User user) {
    return usersRepository.save(user);
    }

    @Override
    public List<Change> getChangeList(String email){
        return usersRepository.findUserByEmail(email).getListChange();               
    }

    @Override
    public List<Change> getAllChanges(){
        List<User> tmp = this.getUsers();
        List<Change> chn = new ArrayList<Change>();
        for (int i = 0; i < tmp.size(); i++) {
            for (int j = 0; j < tmp.get(i).getListChange().size(); j++) {
                chn.add(tmp.get(i).getListChange().get(j));
            }            
        }
        return chn;
    }

    @Override
    public Change addChange(Change change,String email){

        User tmp = this.findUserByEmail(email);
        tmp.addNewChange(change);
        this.usersRepository.save(tmp);
        return change;
    }

    //@Override
    //public Requests addRequests(Requests requests,String email){
    //    return null;
    //}

    //@Override
    //public List<Requests> getAllRequests(String email){
    //    return usersRepository.findUserByEmail(email).getRequests();
    //}


}
