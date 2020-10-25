package com.ydh.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ydh.domain.Product;
import com.ydh.utils.DataSourceUtils;

public class ProductDao {

	public List<Product> findAll() throws SQLException {
		// 查询所有商品
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product";
		return qr.query(sql, new BeanListHandler<>(Product.class));
	}

	public void addProduct(Product p) throws SQLException {
		// 添加商品
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into product(pid,pname,market_price,shop_price,pdate,pdesc) values(?,?,?,?,?,?)";
		qr.update(sql,p.getPid(),p.getPname(),p.getMarket_price(),p.getShop_price(),p.getPdate(),p.getPdesc());
	}

	public Product getProductById(String pid) throws SQLException {
		// 通过商品id获取商品
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product where pid=?";
		return qr.query(sql, new BeanHandler<>(Product.class),pid);
	}

	public Object updateProductById(Product p) throws SQLException {
		// 修改商品信息
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update product set pname = ?,market_price = ?,shop_price = ?,pdesc = ? where pid = ?";
		return qr.update(sql,p.getPname(),p.getMarket_price(),p.getShop_price(),p.getPdesc(),p.getPid());
	}

	public void deleteProductById(String pid) throws SQLException {
		// 删除商品信息
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from product where pid=?";
		qr.update(sql, pid);
	}

}