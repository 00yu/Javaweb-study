package com.ydh.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ydh.domain.PageBean;
import com.ydh.domain.Product;
import com.ydh.web.service.ProductService;
import com.ydh.web.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends BaseServlet {
	/**
	 * 通过id查询单个商品详情
	 */
	public String getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取商品id
		String pid=request.getParameter("pid");
		//2.调用service
		ProductService ps=new ProductServiceImpl();
		Product p=ps.getByPid(pid);
		//3.将结果放入request域中 请求转发
		request.setAttribute("bean", p);
		return "/jsp/product_info.jsp";
	}
	
	public String findByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取类别 当前页 设置一个pagesize
		String cid=request.getParameter("cid");
		int currPage=Integer.parseInt(request.getParameter("currPage"));
		int pageSize=12;
		//2.调用service 返回值pagebean
		ProductService ps=new ProductServiceImpl();
		PageBean<Product> bean=ps.findByPage(currPage,pageSize,cid);
		//3.将结果放入request中 请求转发
		request.setAttribute("pb", bean);
		return "/jsp/product_list.jsp";
	}
}
