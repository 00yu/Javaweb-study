package com.ydh.a_cookie.b_rem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 记录上次访问时间
 */
public class RemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w=response.getWriter();
		//1.获取指定名称的cookie
		Cookie c=getCookieByName("lastTime",request.getCookies());
		//2.判断cookie是否为空
		if(c==null) {
			//cookie为空，提示第一次访问
			w.print("您是第一次访问！");
		}else {
			//cookie不为空 获取value 展示上一次访问的时间
			String value=c.getValue();//lastTime
			long time=Long.parseLong(value);
			Date date=new Date(time);
			w.print("您上次的访问时间："+date.toLocaleString());
		}
		//3.将当前的访问时间记录
		//3.1创建cookie
		c=new Cookie("lastTime",new Date().getTime()+"");
		//持久化cookie
		c.setMaxAge(3600);
		//设置路径
		c.setPath(request.getContextPath()+"/");// /day11/
		//3.2写回浏览器
		response.addCookie(c);
	}

	private Cookie getCookieByName(String name, Cookie[] cookies) {
		//通过名称在cookie数组中获取指定的cookie
		if(cookies!=null) {
			for (Cookie c : cookies) {
				//通过名称获取
				if(name.equals(c.getName())) {
					return c;
				}
			}
		}
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
