package com.ydh.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.ydh.domain.Category;
import com.ydh.domain.Product;
import com.ydh.utils.BeanFactory;
import com.ydh.utils.UUIDUtils;
import com.ydh.utils.UploadUtils;
import com.ydh.web.service.CategoryService;
import com.ydh.web.service.ProductService;

/**
 * Servlet implementation class AdminProductServlet
 */
public class AdminProductServlet extends BaseServlet {
	//查询所有商品信息
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.调用productService查询所有商品信息 返回list集合
		ProductService ps=(ProductService) new BeanFactory().getBean("ProductService");
		List<Product> list=ps.findAll();
		//将list放入request域中 请求转发
		request.setAttribute("list", list);
		return "/admin/product/list.jsp";
	}
	
	//跳转到添加商品页面
	public String addUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//查询所有的分类 返回一个list
		CategoryService cs=(CategoryService) BeanFactory.getBean("CategoryService");
		List<Category> clist = cs.findAll();
		//将list放入request 方便添加页面遍历
		request.setAttribute("clist",clist);
		return "/admin/product/add.jsp";
	}
}
