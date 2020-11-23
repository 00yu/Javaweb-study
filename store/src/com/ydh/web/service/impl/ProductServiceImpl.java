package com.ydh.web.service.impl;

import java.util.List;

import com.ydh.dao.ProductDao;
import com.ydh.dao.impl.ProductDaoImpl;
import com.ydh.domain.PageBean;
import com.ydh.domain.Product;
import com.ydh.web.service.ProductService;

public class ProductServiceImpl implements ProductService {
	//查询最新
	@Override
	public List<Product> findNew() throws Exception {
		ProductDao pdao=new ProductDaoImpl();
		return pdao.findNew();
	}

	//查询热门
	@Override
	public List<Product> findHot() throws Exception {
		ProductDao pdao=new ProductDaoImpl();
		return pdao.findHot();
	}
	
	//根据单个商品详情
	@Override
	public Product getByPid(String pid) throws Exception {
		ProductDao pdao=new ProductDaoImpl();
		return pdao.getByPid(pid);
	}

	//按类别分页查询商品
	@Override
	public PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception {
		ProductDao pdao=new ProductDaoImpl();
		//当前页数据
		List<Product> list=pdao.findByPage(currPage,pageSize,cid);
		//总条数
		int totalCount=pdao.getTotalCount(cid);
		return new PageBean<Product>(list, currPage, pageSize, totalCount);
	}

	@Override
	public List<Product> findAll() throws Exception {
		ProductDao pdao=new ProductDaoImpl();
		return pdao.findAll();
	}

	//添加商品
	@Override
	public void add(Product p) throws Exception {
		ProductDao pdao=new ProductDaoImpl();
		pdao.add(p);
	}
}
