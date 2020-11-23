package com.ydh.service;

import java.sql.SQLException;
import java.util.List;

import com.ydh.dao.ProductDao;
import com.ydh.domain.PageBean;
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

	public void deleteManyProduct(String[] ids) throws SQLException {
		// 删除多个商品
		ProductDao pDao=new ProductDao();
		for (String pid : ids) {
			pDao.deleteProductById(pid);
		}
	}

	public List<Product> findProductByCondition(String name, String kw) throws SQLException {
		//多条件查询 name商品名称 kw关键词
		return new ProductDao().findProductByCondition(name,kw);
	}

	public PageBean<Product> showProductsByPage(int currPage, int pageSize) throws SQLException {
		// 查询当前页数据 查询总条数 limit (当前页-1)*每页显示条数,每页显示条数
		ProductDao dao=new ProductDao();
		List<Product> list=dao.findProductByPage(currPage,pageSize);
		int totalCount=dao.getCount();
		return new PageBean<Product>(list, currPage, pageSize, totalCount);
	}

}
