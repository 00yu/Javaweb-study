package com.ydh.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ydh.domain.Cart;
import com.ydh.domain.CartItem;
import com.ydh.domain.Product;
import com.ydh.utils.BeanFactory;
import com.ydh.web.service.ProductService;

/**
 * 购物车模块
 */
public class CartServlet extends BaseServlet {
	//获取购物车
	public Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//判断cart是否为空
		if(cart==null) {
			//创建一个cart
			cart=new Cart();
			//添加到session中
			request.getSession().setAttribute("cart", cart);
		}
		return cart;
	}
	
	//添加到购物车
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取pid和count
		String pid = request.getParameter("pid");
		int count = Integer.parseInt(request.getParameter("count"));
		//2.通过pid调用ProductService获取对应商品
		ProductService ps=(ProductService) BeanFactory.getBean("ProductService");
		Product product=ps.getByPid(pid);
		//3.组装成CartItem
		CartItem cartItem = new CartItem(product,count);
		//4.添加到购物车中
		Cart cart=getCart(request);
		cart.add2Cart(cartItem);
		//5.重定向
		response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
		return null;
	}
	
	//从购物车中移除购物车项
	public String remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取商品的pid
		String pid = request.getParameter("pid");
		//2.调用购物车的remove方法
		getCart(request).removeFromCart(pid);
		//3.重定向
		response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
		return null;
	}
	
	//清空购物车
	public String clear(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取购物车并清空
		getCart(request).clearCart();
		//重定向
		response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
		return null;
	}
}
