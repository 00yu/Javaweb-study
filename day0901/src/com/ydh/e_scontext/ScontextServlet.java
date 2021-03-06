package com.ydh.e_scontext;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletContext的常用方法
 */
public class ScontextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取全局管理
		ServletContext context=this.getServletContext();
		//获取初始化参数
		System.out.println("初始化参数："+context.getInitParameter("encoding"));
		//获取文件的真实路径
		String path=context.getRealPath("/1.txt");
		System.out.println(path);
		//以流的形式返回一个文件
		InputStream is=context.getResourceAsStream("/1.txt");
		System.out.println(is);
		//获取文件的mime类型
		String mimeType=context.getMimeType("1.jpg");
		System.out.println(mimeType);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
