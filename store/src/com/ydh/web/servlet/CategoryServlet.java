package com.ydh.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ydh.domain.Category;
import com.ydh.utils.BeanFactory;
import com.ydh.utils.JsonUtil;
import com.ydh.web.service.CategoryService;
import com.ydh.web.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends BaseServlet {
	/**
	 * 查询所有的分类
	 * @throws Exception 
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.调用CategoryService查询所有分类 返回值list
		//CategoryService cs=new CategoryServiceImpl();
		CategoryService cs=(CategoryService) BeanFactory.getBean("CategoryService");
		List<Category> clist=cs.findAll();
		//2.将返回值转换成json格式 返回到页面上
		String json = JsonUtil.list2json(clist);
		//写回
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(json);
		return null;
	}
}
