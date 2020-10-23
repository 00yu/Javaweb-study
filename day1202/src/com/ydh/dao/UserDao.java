package com.ydh.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ydh.domain.User;
import com.ydh.utils.DataSourceUtils;

public class UserDao {

	public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
		QueryRunner qr= new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where username=? and password=?";
		return qr.query(sql, new BeanHandler<>(User.class),username,password);
	}

}
