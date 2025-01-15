package com.hunk.commentcraft.service;

import com.hunk.commentcraft.model.Comment;

import java.util.List;

public interface CommentServiceInterface {

    public void postComment(Comment comment);

    public void replyToComment(Integer postId, Integer userId, Integer parentCommentId, String content);

    public void like(Integer commentId);

    public void dislike(Integer commentId);

    public List<Comment> getAllComments();
}
