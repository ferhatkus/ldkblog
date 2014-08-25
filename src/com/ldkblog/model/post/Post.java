package com.ldkblog.model.post;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ldkblog.model.user.User;

public class Post {
	private String id;
	private User user;
	private String title;
	private String content;
	private Date date;

	public String getDateToString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM EEE, YYYY - HH:mm");
		return dateFormat.format(date);
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public User getUSer() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
