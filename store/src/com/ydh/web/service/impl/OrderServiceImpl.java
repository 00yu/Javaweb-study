package com.ydh.web.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ydh.dao.OrderDao;
import com.ydh.domain.Order;
import com.ydh.domain.OrderItem;
import com.ydh.domain.PageBean;
import com.ydh.domain.User;
import com.ydh.utils.BeanFactory;
import com.ydh.utils.DataSourceUtils;
import com.ydh.web.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public void add(Order order) throws Exception{
		try {
			//1.开启事务
			DataSourceUtils.startTransaction();
			//2.向orders表中添加一条数据
			OrderDao od=(OrderDao) BeanFactory.getBean("OrderDao");
			od.add(order);
			//3.向orderitem中添加多条数据
			for (OrderItem oi : order.getItems()) {
				od.addItem(oi);
			}
			//4.事务处理
			DataSourceUtils.commitAndClose();
		} catch (Exception e) {
			e.printStackTrace();
			DataSourceUtils.rollbackAndClose();
			throw e;
		}
	}
	
	//分页查询订单
	@Override
	public PageBean<Order> findAllByPage(int currPage, int pageSize, User user) throws Exception {
		OrderDao od=(OrderDao) BeanFactory.getBean("OrderDao");
		//查询当前页数据
		List<Order> list=od.findAllByPage(currPage,pageSize,user.getUid());
		//查询总条数
		int totalCount=od.getTotalCount(user.getUid());
		return new PageBean<Order>(list, currPage, pageSize, totalCount);
	}
	
	//查看订单详情
	@Override
	public Order getById(String oid) throws Exception {
		OrderDao od=(OrderDao) BeanFactory.getBean("OrderDao");
		return od.getById(oid);
	}

	@Override
	public void updateOrder(Order order) throws Exception {
		OrderDao od=(OrderDao) BeanFactory.getBean("OrderDao");
		od.update(order);
	}

	@Override
	public List<Order> findAllByState(String state) throws Exception {
		OrderDao od=(OrderDao) BeanFactory.getBean("OrderDao");
		return od.findAllByState(state);
	}

}
