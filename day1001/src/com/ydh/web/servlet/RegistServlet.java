package com.ydh.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ydh.domain.User;
import com.ydh.service.UserService;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("utf-8");
		//1.封装数据
		//创建一个User对象 调用User的set方法 不推荐
		//使用beanutils封装对象
		User user=new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		//2.调用userservice.regist(User) 返回值：int
			int i=new UserService().regist(user);
		//3.判断int值 将信息请求转发到msgservlet
			if(i==1) {
				request.setAttribute("msg", "添加成功");
				request.getRequestDispatcher("/msg").forward(request, response);
			}else {
				request.setAttribute("msg", "添加失败");
				request.getRequestDispatcher("/msg").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
