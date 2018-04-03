package com.eci.cosw.springbootsecureapi.service;

 import com.eci.cosw.springbootsecureapi.model.User;
 import com.eci.cosw.springbootsecureapi.repositories.UserRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

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
}
