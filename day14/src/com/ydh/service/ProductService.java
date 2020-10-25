package com.ydh.service;

import java.sql.SQLException;
import java.util.List;

import com.ydh.dao.ProductDao;
import com.ydh.domain.Product;
public class ProductService {

	public List<Product> findAll() throws SQLException {
		// 查询所有的商品
		return new ProductDao().findAll();
	}

	public void addProduct(Product p) throws SQLException {
		//添加商品
		new ProductDao().addProduct(p);
	}

	public Product getProductById(String pid) throws SQLException {
		// 通过id查找商品
		return new ProductDao().getProductById(pid);
	}

	public void updateProduct(Product p) throws SQLException {
		// 修改商品
		new ProductDao().updateProductById(p);
		
	}

	public void deleteProductById(String pid) throws SQLException {
		// 通过pid删除商品
		new ProductDao().deleteProductById(pid);
	}

}
