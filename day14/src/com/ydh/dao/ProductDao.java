package com.ydh.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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

	public List<Product> findProductByCondition(String name, String kw) throws SQLException {
		// 多条件查询
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product where 1=1";
		//存放参数
		ArrayList<String> params=new ArrayList<>();
		//判断参数是否为空 拼接sql
		if(name!=null && name.trim().length()>0) {
			sql+=" and pname like ?";
			params.add("%"+name+"%");
		}
		if(kw!=null && kw.trim().length()>0) {
			sql+=" and pdesc like ?";
			params.add("%"+kw+"%");
		}
		return qr.query(sql, new BeanListHandler<>(Product.class),params.toArray());
	}

	public List<Product> findProductByPage(int currPage, int pageSize) throws SQLException {
		// 查询第几页的数据
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from product limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Product.class),(currPage-1)*pageSize,pageSize);
	}

	public int getCount() throws SQLException {
		// 查询总条数
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from product";
		return ((Long)qr.query(sql, new ScalarHandler<>())).intValue();
	}

}
