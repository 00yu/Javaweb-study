package com.ydh.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ydh.domain.Category;
import com.ydh.utils.BeanFactory;
import com.ydh.utils.UUIDUtils;
import com.ydh.web.service.CategoryService;

/**
 * Servlet implementation class AdminCategoryServlet
 */
public class AdminCategoryServlet extends BaseServlet {
	/**
	 * 展示所有分类
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.调用categoryService查询所有的分类信息 返回值list集合
		CategoryService cs=(CategoryService) BeanFactory.getBean("CategoryService");
		List<Category> list = cs.findAll();
		//2.将list放入request域中 请求转发即可
		request.setAttribute("list", list);
		return "/admin/category/list.jsp";
	}
	
	/**
	 * 跳转到添加页面上
	 */
	public String addUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/admin/category/add.jsp";
	}
	
	/**
	 * 添加分类
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.接收cname
		String cname = request.getParameter("cname");
		//2.封装category
		Category category = new Category();
		category.setCid(UUIDUtils.getId());
		category.setCname(cname);
		//3.调用service完成添加操作
		CategoryService cs=(CategoryService) BeanFactory.getBean("CategoryService");
		cs.add(category);
		//4.重定向查询所有分类
		response.sendRedirect(request.getContextPath()+"/adminCategory?method=findAll");
		return null;
	}
	
	/**
	 * 根据类别id查询类别并跳转到修改页面上
	 */
	public String getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.接收cid
		String cid = request.getParameter("cid");
		//2.调用service完成查询操作
		CategoryService cs=(CategoryService) BeanFactory.getBean("CategoryService");
		Category c=cs.getById(cid);
		//3.将category放入request域中 请求转发
		request.setAttribute("bean", c);
		return "/admin/category/edit.jsp";
	}
	
	/**
	 * 更新分类信息方法
	 */
	public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.接收cid cname
		String cid = request.getParameter("cid");
		String cname=request.getParameter("cname");
		//2.封装
		Category category = new Category();
		category.setCid(cid);
		category.setCname(cname);
		//2.调用service完成更新操作
		CategoryService cs=(CategoryService) BeanFactory.getBean("CategoryService");
		cs.update(category);
		//3.重定向 查询所有类别
		response.sendRedirect(request.getContextPath()+"/adminCategory?method=findAll");
		return null;
	}
	
	/**
	 * 删除分类
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取cid
		String cid = request.getParameter("cid");
		//2.调用service完成删除操作
		CategoryService cs=(CategoryService) BeanFactory.getBean("CategoryService");
		cs.delete(cid);
		//3.重定向 查询所有类别
		response.sendRedirect(request.getContextPath()+"/adminCategory?method=findAll");
		return null;
	}
}
