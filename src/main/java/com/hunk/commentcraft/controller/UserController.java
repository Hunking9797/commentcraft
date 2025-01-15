package com.hunk.commentcraft.controller;

import com.hunk.commentcraft.model.User;
import com.hunk.commentcraft.service.UserServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserServiceInterface userService;

    @Autowired
    public UserController(UserServiceInterface userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> userList = userService.getUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping("/users")
    @Transactional
    public ResponseEntity<String> createUser(@RequestBody User user){
        try{
            userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully!");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating User: " + e.getMessage());
        }
    }
}
