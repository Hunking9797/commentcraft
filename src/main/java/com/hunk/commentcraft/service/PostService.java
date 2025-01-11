package com.hunk.commentcraft.service;

import com.hunk.commentcraft.dao.PostImplementation;
import com.hunk.commentcraft.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostImplementation postDao;

    @Autowired
    public PostService(PostImplementation postDao){
        this.postDao = postDao;
    }

    public List<Post> getPost(){
        return postDao.getAllPosts();
    }

    public void createPost(Post post){
        postDao.createPost(post);
    }

/*
    public void createPost(String title, String content){
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
    }
*/

}
