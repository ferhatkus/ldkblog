package com.lkdnlog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldkblog.model.post.Post;
import com.lkdblog.service.PageService;
import com.lkdblog.service.PostService;
import com.lkdblog.service.SessionService;

public class DetailPostController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SessionService.setIsLoggedIn(req);
		PostService postService = new PostService();
		String postId = (String) req.getParameter("postId");
		Post post = postService.getPost(postId);
		req.setAttribute("post", post);
		PageService.pageForward(req, resp, "detailPost.jsp?postId=" + post.getId());
	}

}
