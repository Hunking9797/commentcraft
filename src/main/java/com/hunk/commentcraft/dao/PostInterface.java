package com.hunk.commentcraft.dao;

import com.hunk.commentcraft.model.Post;

import java.util.List;

public interface PostInterface {

    public List<Post> getAllPosts();

    public void createPost(Post post);

}
