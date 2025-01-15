package com.hunk.commentcraft.dao;
import com.hunk.commentcraft.model.Comment;
import com.hunk.commentcraft.model.Post;
import com.hunk.commentcraft.model.User;

import java.util.List;

public interface CommentDaoInterface {

    public void postComment(Comment comment);

    public Post findPostById(Integer id);

    public User findUserById(Integer id);

    public Comment findCommentById(Integer id);

    public void like(Comment comment);

    public void dislike(Comment comment);

    public List<Comment> getAllComments();
}
