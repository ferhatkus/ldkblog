package com.lkdblog.dao;


import java.util.Collection;

import com.ldkblog.model.post.Post;
import com.ldkblog.model.user.User;


public class PostDao {

	public boolean save(Post post) {

		if (post.getId() == null || post.getId().trim().length() == 0) {
			String id = String.valueOf(System.currentTimeMillis());
			post.setId(id);
		}

		FakeDb.save(post.getId(), post);

		return true;
	}

	public Collection<Post> getAllPosts() {
		return FakeDb.getAllPosts();
	}
	
	public Collection<Post> getAllPostsOfUser(User user) {
		return FakeDb.getAllPostsOfUser(user);
		
	}

	public Post getPost(String postId) {
		
		return FakeDb.getPost(postId);
	}

}
