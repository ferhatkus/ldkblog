package com.lkdblog.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class SessionService {
	private static HttpSession session = null;
	public static void setIsLoggedIn(HttpServletRequest req) {
		session = req.getSession();
		boolean isLoggedin = session.getAttribute("isLoggedin") != null ? (boolean) session
				.getAttribute("isLoggedin") : false;
		req.setAttribute("isLoggedin", isLoggedin);

	}
	
	public static void logoutUser(HttpServletRequest req) {
		session = req.getSession();
		session.invalidate();
	}
}
