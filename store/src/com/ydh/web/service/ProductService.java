package com.ydh.web.service;

import java.util.List;

import com.ydh.domain.PageBean;
import com.ydh.domain.Product;

public interface ProductService {

	List<Product> findNew() throws Exception;

	List<Product> findHot() throws Exception;

	Product getByPid(String pid) throws Exception;

	PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception;

	List<Product> findAll() throws Exception;

	void add(Product p) throws Exception;

}
