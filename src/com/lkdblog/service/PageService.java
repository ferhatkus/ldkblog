package com.lkdblog.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class PageService {
	public static void pageForward(HttpServletRequest req,
			HttpServletResponse resp, String includePageName) throws ServletException, IOException {
		req.setAttribute("includePageName", includePageName);
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}

}
