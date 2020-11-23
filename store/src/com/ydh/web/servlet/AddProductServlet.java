package com.ydh.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
import com.ydh.web.service.ProductService;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//0.创建一个map集合 用来放入前台传递数据(注意修改成文件上传的enctype后不能用request.getParameter获取表单提交数据)
			Map<String,Object> map=new HashMap<>();
			//创建一个磁盘文件项工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//创建一个核心文件上传对象 ServletFileUpLoad
			ServletFileUpload upload = new ServletFileUpload(factory);
			//上传对象调用方法解析请求 获取一个List<FileItem>
			List<FileItem> list = upload.parseRequest(request);
			//遍历list获取每一个文件项
			for (FileItem fi : list) {
				//判断是否为普通的上传组件
				if(fi.isFormField()) {
					//普通的上传组件 
					map.put(fi.getFieldName(), fi.getString("utf-8"));//getFiledName():获取表单子标签的name属性值  getString("utf-8"):获取用户输入的值
				}else {
					//文件上传组件
					//获取文件名称
					String name = fi.getName();//getName()获取上传文件名称
					//获取文件的真实名称(不带路径)
					String realName = UploadUtils.getRealName(name);
					//获取文件的随机名称
					String uuidName = UploadUtils.getUUIDName(realName);
					//获取文件存放路径
					String path = this.getServletContext().getRealPath("/products/1");
					//获取文件流
					InputStream is = fi.getInputStream();//getInputStream()获取上传文件流
					//保存图片
					FileOutputStream os = new FileOutputStream(new File(path, uuidName));
					IOUtils.copy(is, os);
					os.close();
					is.close();
					//删除临时文件
					fi.delete();
					//在map中设置文件路径
					map.put(fi.getFieldName(), "products/1/"+uuidName);
				}
			}
			//1.封装参数
			Product p = new Product();
			BeanUtils.populate(p, map);
			//1.1商品id
			p.setPid(UUIDUtils.getId());
			//1.2商品时间
			p.setPdate(new Date());
			//1.3封装category
			Category c = new Category();
			c.setCid((String)map.get("cid"));
			p.setCategory(c);
			//2.调用service完成添加操作
			ProductService ps=(ProductService) new BeanFactory().getBean("ProductService");
			ps.add(p);
			//3.页面重定向
			response.sendRedirect(request.getContextPath()+"/adminProduct?method=findAll");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "商品添加失败~~~");
			request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
			return;
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
