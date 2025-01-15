package com.hunk.commentcraft.service;

import com.hunk.commentcraft.model.User;

import java.util.List;

public interface UserServiceInterface {

    public void createUser(User user);

    public List<User> getUsers();
}
