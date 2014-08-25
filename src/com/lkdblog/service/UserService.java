package com.lkdblog.service;

import java.util.Collection;

import com.ldkblog.model.user.User;
import com.lkdblog.dao.UserDao;


public class UserService {
	private UserDao userDao;

	public boolean save(User user) {
		
		// TODO validate username
		// TODO  validate password

		return getUserDao().save(user);

	}

	private UserDao getUserDao() {
		if (this.userDao == null) {
			this.userDao = new UserDao();
		}

		return this.userDao;
	}

	public Collection<User> getAllUsers() {
		return getUserDao().getAllUsers();
	}

	public User checkAuthentication(String username, String password) {
		return getUserDao().checkAuthetication(username, password);
	}
}
