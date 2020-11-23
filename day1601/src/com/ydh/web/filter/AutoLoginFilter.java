package com.ydh.web.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ydh.domain.User;
import com.ydh.utils.CookieUtils;
import com.ydh.web.service.UserService;

public class AutoLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//1.强转
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		//2.1首先判断session中是否有user
		User user=(User) request.getSession().getAttribute("user");
		if(user==null) {
			//没有用户 需要自动登录
			//2.2判断访问的路径是否和登录注册相关
			String path=request.getRequestURI();
			if(!path.contains("/login")) {
				//2.3获取指定cookie
				Cookie c=CookieUtils.getCookieByName("autologin", request.getCookies());
				//判断cookie是否为空
				//若不为空 获取值(username和password) 调用service完成登录 判断user是否为空 若不为空放入session
				if(c!=null) {
					String username=c.getValue().split("-")[0];
					String password=c.getValue().split("-")[1];
					try {
						user = new UserService().login(username,password);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(user!=null) {
						//将user放入session中
						request.getSession().setAttribute("user", user);
					}
				}
			}
		}
		
		
		//3.放行
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
