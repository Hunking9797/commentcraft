package com.hunk.commentcraft.service;

import com.hunk.commentcraft.dao.UserDaoInterface;
import com.hunk.commentcraft.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{

    private UserDaoInterface userDao;

    @Autowired
    public UserService(UserDaoInterface userDao){
        this.userDao = userDao;
    }

    @Transactional
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
