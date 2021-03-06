package com.ydh.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.Cookies;

import com.ydh.utils.CookieUtils;

/**
 * 记录商品浏览历史
 */
public class GetProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		//0.1获取当前访问的id
		String id=request.getParameter("id");
		//1.获取指定的cookie
		Cookie c=CookieUtils.getCookieByName("ids", request.getCookies());
		String ids="";
		//2.判断cookie是否为空
		if(c==null) {
			//若cookie为空 需要将当前商品id放入ids中
			ids=id;
		}else {
			//若cookie不为空 继续判断ids中是否已经包含该商品id
			//获取值
			ids=c.getValue();
			//切割
			String[] arr=ids.split("-");
			//数组转成集合 此list长度不可变
			List<String> asList=Arrays.asList(arr);
			//将aslist放入一个新list中
			LinkedList<String> list=new LinkedList<>(asList);
			if(list.contains(id)){
				//若ids中包含id 将id移除放到最前面
				list.remove(id);
				list.addFirst(id);
			}else {
				//若不包含 继续判断长度是否大于等于3
				if(list.size()>=3) {
					//移除最后一个，将当前放在最前面
					list.removeLast();
					list.addFirst(id);
				}else {
					//将当前放入最前面
					list.addFirst(id);
				}
			}
			ids="";
			//将list转成字符串
			for (String s : list) {
				ids+=(s+"-");
			}
			ids=ids.substring(0, ids.length()-1);
		}
		//将ids写回去
		c=new Cookie("ids",ids);
		//设置访问路径
		c.setPath(request.getContextPath()+"/");
		//设置存活时间
		c.setMaxAge(3600);
		//写回浏览器
		response.addCookie(c);
		//3.跳转到指定的商品页面中
		response.sendRedirect(request.getContextPath()+"/product_info"+id+".htm");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
