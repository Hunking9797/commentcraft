package com.hunk.commentcraft.dao;

import com.hunk.commentcraft.model.User;

import java.util.List;

public interface UserInterface {
    public void createUser(User user);

    public List<User> getAllUsers();
}