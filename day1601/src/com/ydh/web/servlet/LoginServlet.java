package com.ydh.web.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ydh.constant.Constant;
import com.ydh.domain.User;
import com.ydh.web.service.UserService;

/**
 * 登录
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("utf-8");
		//1.获取用户名和密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//2.调用service
		User user = null;
		try {
			user = new UserService().login(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.判断user是否为空
		if(user==null) {
			request.setAttribute("msg", "用户名和密码不匹配");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else {
			
			//若不为空，跳转到success.jsp
			request.getSession().setAttribute("user", user);
			//判断是否勾选了自动登录 若勾选需要将用户名和密码放入cookie中，写回浏览器
			if(Constant.IS_AUTO_LOGIN.equals(request.getParameter("autoLogin"))) {
				//创建cookie 注意中文
				Cookie c=new Cookie("autologin",username+"-"+password);
				c.setMaxAge(3600);
				c.setPath(request.getContextPath()+"/");
				response.addCookie(c);
			}
			
			//判断是否勾选了记住用户名 若勾选了需要将用户名放入cookie中 写回浏览器
			if(Constant.IS_SAVE_NAME.equals(request.getParameter("saveName"))) {
				//创建cookie
				Cookie c=new Cookie("savename",URLEncoder.encode(username, "utf-8"));
				c.setMaxAge(3600);
				c.setPath(request.getContextPath()+"/");
				response.addCookie(c);
			}
			
			//页面重定向
			response.sendRedirect(request.getContextPath()+"/success.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
