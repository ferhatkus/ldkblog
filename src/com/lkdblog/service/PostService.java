package com.lkdblog.service;

import java.util.Collection;

import com.ldkblog.model.post.Post;
import com.ldkblog.model.user.User;
import com.lkdblog.dao.PostDao;

public class PostService {
	private PostDao postDao;

	public boolean save(Post post) {

		return getPostDao().save(post);

	}

	private PostDao getPostDao() {
		if (this.postDao == null) {
			this.postDao = new PostDao();
		}

		return this.postDao;
	}

	public Collection<Post> getAllPosts() {
		return getPostDao().getAllPosts();
	}
	
	public Collection<Post> getAllPostsOfUser(User user) {
		return getPostDao().getAllPostsOfUser(user);
	}
	
	public Post getPost(String postId) {
		return getPostDao().getPost(postId);
	}

}
