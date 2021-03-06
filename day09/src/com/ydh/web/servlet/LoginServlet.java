package com.ydh.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ydh.domain.User;
import com.ydh.service.UserService;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//0.设置编码
		resp.setContentType("text/html;charset=utf-8");
		//1.接收用户名和密码
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		//2.调用userservice里的login(username,password)	返回值：User对象
		User user = null;
		try {
			user = new UserService().login(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("网络异常，请稍后再试");
		}
		//3.判断user是否为空
		//若为空写"用户名和密码不匹配"，若不为空写"xxx:欢迎回来"
		if(user==null) {
			resp.getWriter().print("用户名和密码不匹配,3s之后跳转");
			//案例2-定时跳转
			resp.setHeader("refresh", "3;url=/day09/login.htm");
		}else {
			resp.getWriter().print(user.getUsername()+":欢迎回来");
		}
	}
}
