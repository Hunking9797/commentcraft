package com.hunk.commentcraft;

import com.hunk.commentcraft.dao.CommentImplementation;
import com.hunk.commentcraft.dao.PostImplementation;
import com.hunk.commentcraft.dao.UserImplementation;
import com.hunk.commentcraft.model.Comment;
import com.hunk.commentcraft.model.Post;
import com.hunk.commentcraft.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommentcraftApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentcraftApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserImplementation userDao, PostImplementation postDao, CommentImplementation commentDao){
		return runner -> {
//			createPost(postDao);
//			postComment(commentDao,1,1);
//			replyToComment(commentDao,1,1,2);
		};
	}

	private void replyToComment(CommentImplementation commentDao, int postId, int userId, int parentCommentId) {
		Comment comment = new Comment();

		Comment parentComment = commentDao.findCommentById(parentCommentId);
		Post post = commentDao.findPostById(postId);
		User user = commentDao.findUserById(userId);

		comment.setContent("Its a reply to comment");
		comment.setPost(post);
		comment.setUser(user);
		comment.setParentComment(parentComment);

		commentDao.postComment(comment);
	}

	private void postComment(CommentImplementation commentDao, int postId, int userId) {
		Comment comment = new Comment();
		Post post = commentDao.findPostById(postId);
		User user = commentDao.findUserById(userId);

		comment.setContent("Ha Ha nice blog....");
		comment.setPost(post);
		comment.setUser(user);

		commentDao.postComment(comment);
	}

	private void createPost(PostImplementation postDao) {
		Post post = new Post();
		post.setContent("2Lorem ipsum is a sample post.....");
		post.setTitle("Sample Post2");
		postDao.createPost(post);
	}

}
