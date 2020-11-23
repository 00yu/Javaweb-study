package com.ydh.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * get请求
 */
public class Ajax2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		String username=request.getParameter("username");
		username=new String(username.getBytes("iso-8859-1"),"utf-8");
		System.out.println(username);
		//响应数据
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("姓名："+username);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getMethod());
		request.setCharacterEncoding("utf-8");
		//接收参数
		String username=request.getParameter("username");
		System.out.println(username);
		//响应数据
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("post姓名："+username);
	}

}
