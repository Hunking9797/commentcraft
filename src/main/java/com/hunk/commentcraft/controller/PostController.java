package com.hunk.commentcraft.controller;

import com.hunk.commentcraft.model.Post;
import com.hunk.commentcraft.service.PostServiceInterface;
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
public class PostController {

    private PostServiceInterface postService;

    @Autowired
    public PostController(PostServiceInterface postService){
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts(){
        List<Post> posts = postService.getPost();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/posts")
    @Transactional
    public ResponseEntity<String> createPost(@RequestBody Post post){
        try{
            postService.createPost(post);
            return ResponseEntity.status(HttpStatus.OK).body("Post created successfully!");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating post: " + e.getMessage());
        }
    }
}
