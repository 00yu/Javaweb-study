package com.ydh.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ydh.domain.User;
import com.ydh.utils.DataSourceUtils;
//只进行数据库的增删改查
public class UserDao {
	//登录 返回User
	public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
		//创建queryrunner
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		//编写sql
		String sql="select * from user where username= ? and password = ?";
		//执行sql
		User user=qr.query(sql, new BeanHandler<>(User.class),username,password);
		return user;
	}

}
