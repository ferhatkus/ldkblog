package com.lkdnlog.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldkblog.model.post.ImagePost;
import com.ldkblog.model.post.Post;
import com.ldkblog.model.post.TextPost;
import com.ldkblog.model.post.VideoPost;
import com.lkdblog.service.PageService;
import com.lkdblog.service.PostService;
import com.lkdblog.service.SessionService;

//@WebServlet("/PostCreat")
public class PostCreatController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionService.setIsLoggedIn(req);
		PageService.pageForward(req, resp, "createPost.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("concent");
		String url = req.getParameter("url");
		String postTYpe = req.getParameter("postType");
		Post post = null;
		PostService postService = new PostService();
		
		if (postTYpe.equals("text")) {
			TextPost text = new TextPost();
			text.setTitle(title);
			text.setContent(content);
			post = text;

		} else if (postTYpe.equals("video")) {
			VideoPost video = new VideoPost();
			video.setTitle(title);
			video.setContent(content);
			video.setUrl(url);
			post = video;

		} else if (postTYpe.equals("img")) {
			ImagePost img = new ImagePost();
			img.setTitle(title);
			img.setContent(content);
			img.setUrl(url);
			post = img;
		}
		
		post.setDate(new Date());
		boolean succes = postService.save(post);
		String message = "Succesuful";
		if (!succes) {
			message = "Not Succesuful";
		}

		req.setAttribute("message", message);
		req.setAttribute("isSucces", succes);
		PageService.pageForward(req, resp, "createPost.jsp");
	}

}
