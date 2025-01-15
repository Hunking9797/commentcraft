package com.hunk.commentcraft.service;

import com.hunk.commentcraft.model.Post;
import jakarta.transaction.Transactional;

import java.util.List;

public interface PostServiceInterface {

    public List<Post> getPost();

    public void createPost(Post post);
}
