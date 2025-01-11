package com.hunk.commentcraft.dao;

import com.hunk.commentcraft.model.Comment;
import com.hunk.commentcraft.model.Post;
import com.hunk.commentcraft.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CommentImplementation implements CommentInterface{

    private EntityManager entityManager;

    @Autowired
    public CommentImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void postComment(Comment comment) {
        try{
            Post post = entityManager.find(Post.class, comment.getPost().getPostId());
            if(post != null){
                comment.setPost(post);
            }
            User user = entityManager.find(User.class, comment.getUser().getUserId());
            if(user != null){
                comment.setUser(user);
            }
            entityManager.persist(comment);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Post findPostById(Integer id) {
        Post post = null;
        post = entityManager.find(Post.class, id);

        return post;
    }

    @Override
    public User findUserById(Integer id) {
        User user = null;
        user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public Comment findCommentById(Integer id) {
        Comment comment = null;
        comment = entityManager.find(Comment.class, id);
        return comment;
    }

    @Override
    @Transactional
    public void like(Comment comment) {
        entityManager.merge(comment);
    }

    @Override
    @Transactional
    public void dislike(Comment comment) {
        entityManager.merge(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        TypedQuery<Comment> query = entityManager.createQuery("SELECT c FROM Comment c", Comment.class);
        List<Comment> comments = query.getResultList();
        return comments;
    }
}
