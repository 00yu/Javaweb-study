package com.ydh.b_request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收参数
		String value=req.getParameter("username");
		//往浏览器回写数据
		//resp.getWriter().print("data:"+value);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print("数据:"+value);
		System.out.println(value);
	}
}
