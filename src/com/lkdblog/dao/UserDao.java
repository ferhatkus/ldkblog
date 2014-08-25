package com.lkdblog.dao;


import java.util.Collection;

import com.ldkblog.model.user.User;


public class UserDao {

	public boolean save(User user) {

		if (user.getId() == null || user.getId().trim().length() == 0) {
			String id = String.valueOf(System.currentTimeMillis());
			user.setId(id);
		}

		FakeDb.save(user.getId(), user);

		return true;
	}

	public Collection<User> getAllUsers() {
		return FakeDb.getAllUsers();

	}

	public User checkAuthetication(String username, String password) {
		for (Object u : FakeDb.getAllUsers()) {

			try {
				User user = (User) u;

				if (user.getUserName().equals(username)
						&& user.getPassword().equals(password)) {
					return user;
				}

			} catch (Exception e) {
				// ignore
			}
		}
		return null;

	}

}
