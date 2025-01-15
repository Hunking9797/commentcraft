package com.hunk.commentcraft.dao;

import com.hunk.commentcraft.model.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDaoImplementation implements PostDaoInterface {


    private EntityManager entityManager;

    @Autowired
    public void PostImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Post> getAllPosts(){
        TypedQuery<Post> query = entityManager.createQuery("SELECT p from Post p", Post.class);
        List<Post> posts = query.getResultList();
        return posts;
    }

    @Override
    public void createPost(Post post) {
        entityManager.persist(post);
    }
}
