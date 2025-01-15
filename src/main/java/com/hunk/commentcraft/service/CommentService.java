package com.hunk.commentcraft.service;

import com.hunk.commentcraft.dao.CommentDaoInterface;
import com.hunk.commentcraft.model.Comment;
import com.hunk.commentcraft.model.Post;
import com.hunk.commentcraft.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements CommentServiceInterface{

    private CommentDaoInterface commentDao;

    @Autowired
    public CommentService(CommentDaoInterface commentDao){
        this.commentDao = commentDao;
    }

    @Transactional
    public void postComment(Comment comment){
        commentDao.postComment(comment);
    }

    @Transactional
    public void replyToComment(Integer postId, Integer userId, Integer parentCommentId, String content){
        Comment parentComment = commentDao.findCommentById(parentCommentId);
        parentComment.setContent(content);

        Post post = commentDao.findPostById(postId);
        User user = commentDao.findUserById(userId);

        parentComment.setPost(post);
        parentComment.setUser(user);
        parentComment.setParentComment(parentComment);

        commentDao.postComment(parentComment);
    }

    @Transactional
    public void like(Integer commentId){
        Comment comment = commentDao.findCommentById(commentId);
        comment.setLikes(comment.getLikes() + 1);
        commentDao.like(comment);
    }

    @Transactional
    public void dislike(Integer commentId){
        Comment comment = commentDao.findCommentById(commentId);
        comment.setLikes(comment.getLikes() - 1);
        commentDao.dislike(comment);
    }

    public List<Comment> getAllComments(){
        return commentDao.getAllComments();
    }

}
