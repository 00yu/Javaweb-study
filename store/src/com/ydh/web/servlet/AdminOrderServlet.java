package com.ydh.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ydh.domain.Order;
import com.ydh.domain.OrderItem;
import com.ydh.utils.BeanFactory;
import com.ydh.utils.JsonUtil;
import com.ydh.web.service.OrderService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * Servlet implementation class AdminOrderServlet
 */
public class AdminOrderServlet extends BaseServlet {
	public String findAllByState(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.接收state
		String state = request.getParameter("state");
		OrderService os=(OrderService) new BeanFactory().getBean("OrderService");
		//2.调用service
		List<Order> list=os.findAllByState(state);
		//3.将list放入域中 请求转发
		request.setAttribute("list", list);
		return "/admin/order/list.jsp";
	}
	
	//查询订单详情
	public String getDetailByOid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		//1.接收oid
		String oid = request.getParameter("oid");
		//2.调用service查询订单详情 返回值list<OrderItem>
		OrderService os=(OrderService) new BeanFactory().getBean("OrderService");
		List<OrderItem> items = os.getById(oid).getItems();
		//3.将list转成json 写回
		//排除不用写回的数据
		JsonConfig config = JsonUtil.configJson(new String[] {"class","itemid","order"});
		JSONArray json = JSONArray.fromObject(items, config);
		response.getWriter().println(json);
		return null;
	}
	
	//修改订单状态
	public String updateState(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.接收oid和state
		String oid = request.getParameter("oid");
		String state = request.getParameter("state");
		//2.调用service
		OrderService os=(OrderService) BeanFactory.getBean("OrderService");
		Order order = os.getById(oid);
		order.setState(Integer.parseInt(state));
		os.updateOrder(order);
		//3.页面重定向到未发货页面
		response.sendRedirect(request.getContextPath()+"/adminOrder?method=findAllByState&state=1");
		return null;
	}
}
