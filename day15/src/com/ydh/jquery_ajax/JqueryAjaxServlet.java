package com.ydh.jquery_ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jquery的ajax
 */
public class JqueryAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("请求的方式："+request.getMethod());
		//接收参数
		String username=request.getParameter("username");
		username=new String(username.getBytes("iso-8859-1"),"utf-8");
		System.out.println(username);
		//响应数据
		response.getWriter().print("success");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("请求的方式："+request.getMethod());
		//接收参数
		String username=request.getParameter("username");
		System.out.println(username);
		//{"res":"success","msg":"成功"}
		String s="{\"res\":\"success\",\"msg\":\"成功\"}";
		//响应数据
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(s);
	}

}
