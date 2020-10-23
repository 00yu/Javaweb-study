package com.ydh.service;

import java.sql.SQLException;
import java.util.List;

import com.ydh.dao.ProductDao;
import com.ydh.domain.Product;

public class ProductService {

	public List<Product> findAll() throws SQLException {
		return new ProductDao().findAll();
	}

}
