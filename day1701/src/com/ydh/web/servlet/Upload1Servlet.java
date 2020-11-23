package com.ydh.web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 * Servlet implementation class Upload1Servlet
 */
@WebServlet("/upload1")
@MultipartConfig
public class Upload1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取username
		String username=request.getParameter("username");
		System.out.println(username);
		//获取f,获取内容为空
		/*
		 * String f=request.getParameter("f"); System.out.println(f);
		 */
		Part part=request.getPart("f");
		String name=part.getName();
		//获取的是name的值
		System.out.println(name);
		String dis=part.getHeader("Content-disposition");
		System.out.println(dis);
		String s=dis.substring(dis.indexOf("filename=")+10,dis.length()-1);
		System.out.println(s);
		InputStream is=part.getInputStream();
		FileOutputStream os=new FileOutputStream("d:/"+s);
		IOUtils.copy(is, os);
		os.close();
		is.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
