package com.hunk.commentcraft.service;

import com.hunk.commentcraft.dao.PostDaoInterface;
import com.hunk.commentcraft.model.Post;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements PostServiceInterface{

    private PostDaoInterface postDao;

    @Autowired
    public PostService(PostDaoInterface postDao){
        this.postDao = postDao;
    }

    public List<Post> getPost(){
        return postDao.getAllPosts();
    }

    @Transactional
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
