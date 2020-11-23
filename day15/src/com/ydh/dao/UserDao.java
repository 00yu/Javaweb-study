package com.ydh.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ydh.domain.User;
import com.ydh.utils.DataSourceUtils;

public class UserDao {

	public User getUserByUsername4Ajax(String username) throws SQLException {
		// 通过用户名获取一个用户
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where username = ? limit 1";
		return qr.query(sql, new BeanHandler<>(User.class),username);
	}

}
