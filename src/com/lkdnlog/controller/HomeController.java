package com.lkdnlog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ldkblog.model.user.User;
import com.lkdblog.service.PageService;
import com.lkdblog.service.PostService;
import com.lkdblog.service.SessionService;
import com.lkdblog.service.UserService;

public class HomeController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getServletPath().equals("/Logout")) {
			SessionService.logoutUser(req);
		} else {

			SessionService.setIsLoggedIn(req);
			PostService postService = new PostService();
			req.setAttribute("postList", postService.getAllPosts());
		}

		PageService.pageForward(req, resp, "postList.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = (String) req.getParameter("username");
		String password = (String) req.getParameter("password");

		UserService userService = new UserService();
		User user = userService.checkAuthentication(username, password);

		HttpSession session = req.getSession();
		session.setAttribute("isLoggedin", user != null);
		session.setAttribute("message", user != null ? "" : "Giriþ iþlemi Baþarýsýz..");
		session.setAttribute("user", user);
		PageService.pageForward(req, resp, "postList.jsp");

	}
}
