package com.lkdblog.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class FileUploadService extends FileUpload {
	public static String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				return null;

	}
}
