package com.lkdnlog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldkblog.model.user.User;
import com.lkdblog.service.FileUploadService;
import com.lkdblog.service.UserService;

public class UserRegistryController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


		req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req,
				resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = (String) req.getParameter("username");
		String password = (String) req.getParameter("password");
		
		

		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		String profilePhotoUrl = FileUploadService.processRequest(req, resp);
		user.setProfilePhotoUrl(profilePhotoUrl);

		UserService userService = new UserService();
		boolean result = userService.save(user);
		
		req.setAttribute("succes", result);
		String message = "User Resgistry is not success";
		
		if (result) {
			message = "User Registry is Succses";
		}
		
		
		req.setAttribute("message", message);	
		req.setAttribute("isUserRegistry", result);
		req.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(req, resp);

		
	}
}
