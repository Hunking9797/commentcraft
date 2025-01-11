package com.hunk.commentcraft.service;

import com.hunk.commentcraft.dao.UserImplementation;
import com.hunk.commentcraft.model.User;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserImplementation userDao;

    @Autowired
    public UserService(UserImplementation userDao){
        this.userDao = userDao;
    }

    public void createUser(User user){
        userDao.createUser(user);
    }

//    public void createUser(String name, String email){
//        User user = new User();
//        user.setUserName(name);
//        user.setEmailAddress(email);
//        userDao.createUser(user);
//    }

    public List<User> getUsers(){
        return userDao.getAllUsers();
    }
}
