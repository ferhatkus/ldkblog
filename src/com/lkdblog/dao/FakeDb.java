package com.lkdblog.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.ldkblog.model.post.Post;
import com.ldkblog.model.user.User;

public class FakeDb {

	private static Map<String, User> userStorage;
	private static Map<String, Post> postStorage;

	static {
		userStorage = new HashMap<String, User>();
		postStorage = new HashMap<String, Post>();
	}

	public static boolean save(String key, User value) {
		userStorage.put(key, value);
		return true;
	}

	public static boolean save(String key, Post value) {
		postStorage.put(key, value);
		return true;

	}

	public static Collection<User> getAllUsers() {
		return userStorage.values();

	}
	
	public static Collection<Post> getAllPosts() {
		return postStorage.values();
	}
	
	public static Collection<Post> getAllPostsOfUser(User user) {
		Collection<Post> posts = postStorage.values();
		Map<String, Post> postsOfUser = new HashMap<String, Post>();
		for (Post post : posts) {
			User userOfPost = post.getUSer();
			if (userOfPost.getId().equals(user.getId())) {
				postsOfUser.put(post.getId(), post);
			}
		}
		return postsOfUser.values();
	}

	public static Post getPost(String postId) {
		return postStorage.get(postId);
	}
}
