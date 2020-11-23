package com.ydh.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ydh.domain.Category;
import com.ydh.domain.Product;
import com.ydh.web.service.CategoryService;
import com.ydh.web.service.ProductService;
import com.ydh.web.service.impl.CategoryServiceImpl;
import com.ydh.web.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends BaseServlet {
	public String index(HttpServletRequest request, HttpServletResponse response){
		// 去数据库中查询最新商品和热门商品 将它们放入request域中 请求转发
		ProductService ps=new ProductServiceImpl();
		List<Product> newList=null;
		List<Product> hotList=null;
		try {
			//最新商品
			newList = ps.findNew();
			//热门商品
			hotList=ps.findHot();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//将两个List放入域中
		request.setAttribute("nList", newList);
		request.setAttribute("hList", hotList);
		return "/jsp/index.jsp";
	}
}
