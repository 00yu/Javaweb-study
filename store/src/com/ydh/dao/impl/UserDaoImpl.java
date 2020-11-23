package com.ydh.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ydh.dao.UserDao;
import com.ydh.domain.User;
import com.ydh.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao{
	/**
	 * 添加用户
	 */
	@Override
	public void add(User user) throws Exception{
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql,user.getUid(),user.getUsername(),user.getPassword(),
				user.getName(),user.getEmail(),user.getTelephone(),
				user.getBirthday(),user.getSex(),user.getState(),user.getCode());
	}
	
	/**
	 * 通过激活码获取用户
	 * @throws Exception 
	 */
	@Override
	public User getByCode(String code) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where code=? limit 1";
		return qr.query(sql, new BeanHandler<>(User.class),code);
	}
	
	/**
	 * 用户信息更新
	 * @throws SQLException 
	 */
	@Override
	public void update(User user) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update user set username=?,password=?,name=?,email=?,birthday=?,state=?,code=? where uid=?";
		qr.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getBirthday(),
				user.getState(),null,user.getUid());
	}

	/**
	 * 用户登录
	 * @throws SQLException 
	 */
	@Override
	public User getByUsernameAndPwd(String username, String password) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where username=? and password=? limit 1";
		return qr.query(sql, new BeanHandler<>(User.class),username,password);
	}
	
}
