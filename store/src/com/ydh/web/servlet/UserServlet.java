package com.ydh.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.ydh.constant.Constant;
import com.ydh.domain.User;
import com.ydh.myconverter.MyConverter;
import com.ydh.utils.MD5Utils;
import com.ydh.utils.UUIDUtils;
import com.ydh.web.service.UserService;
import com.ydh.web.service.impl.UserServiceImpl;

/**
 * 和用户相关的Servlet
 */
public class UserServlet extends BaseServlet {
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet的add方法执行了");
		return null;
	}
	/**
	 * 跳转到注册页面 
	 */
	public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "jsp/register.jsp";
	}
	/**
	 * 用户注册 
	 * @throws Exception 
	 */
	public String regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.封装数据
		User user=new User();
		//注册自定义转化器(String类型转换为Date类型)
		ConvertUtils.register(new MyConverter(), Date.class);
		BeanUtils.populate(user, request.getParameterMap());
		//1.1设置用户id
		user.setUid(UUIDUtils.getId());
		//1.2设置激活码
		user.setCode(UUIDUtils.getCode());
		//1.3加密密码
		user.setPassword(MD5Utils.md5(user.getPassword()));
		//2.调用service完成注册
		UserService s=new UserServiceImpl();
		s.regist(user);
		//3.页面请求转发
		request.setAttribute("msg", "用户注册已成功，请去邮箱激活");
		return "/jsp/msg.jsp";
	}
	
	/**
	 * 用户激活
	 * @throws Exception 
	 */
	public String active(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取激活码
		String code = request.getParameter("code");
		//2.调用service完成激活
		UserService s=new UserServiceImpl();
		User user=s.active(code);
		if(user==null) {
			//通过激活码没有寻找到用户
			request.setAttribute("msg", "请重新激活");
		}else {
			//添加信息
			request.setAttribute("msg", "激活成功");
		}
		//3.请求转发到msg.jsp
		return "jsp/msg.jsp";
	}
	
	/**
	 * 跳转到登录页面 
	 */
	public String loginUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "jsp/login.jsp";
	}
	
	/**
	 * 用户登录
	 * @throws Exception 
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取用户名和密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		password=MD5Utils.md5(password);
		//2.调用service完成登录操作 返回user
		UserService s=new UserServiceImpl();
		User user=s.login(username,password);
		//3.判断用户
		if(user==null) {
			//用户名密码不匹配
			request.setAttribute("msg", "用户名密码不匹配");
			return "/jsp/login.jsp";
		}else {
			//继续判断用户状态是否激活
			if(Constant.USER_IS_ACTIVE!=user.getState()) {
				request.setAttribute("msg","用户未激活");
				return "/jsp/login.jsp";
			}
		}
		//4.将user放入session中 重定向
		request.getSession().setAttribute("user", user);
		response.sendRedirect(request.getContextPath()+"/");//重定向到根目录即首页
		return null;
	}
	
	/**
	 * 用户退出
	 */
	public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//干掉session
		request.getSession().invalidate();
		//重定向
		response.sendRedirect(request.getContextPath());
		//处理自动登录(干掉cookie)
		return null;
	}
}
