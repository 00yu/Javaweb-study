package com.ydh.web.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.ydh.utils.DataSourceUtils;

public class AccountDao4DB {

	public void accountOut(String fromUser, String money) throws SQLException {
		//创建queryrunner
		QueryRunner qr=new QueryRunner();
		//编写sql
		String sql="update account set money = money - ? where name = ?";
		//执行sql
		qr.update(DataSourceUtils.getConnection(), sql, money,fromUser);
	}

	public void accountIn(String toUser, String money) throws SQLException {
		//创建queryrunner
		QueryRunner qr=new QueryRunner();
		//编写sql
		String sql="update account set money = money + ? where name = ?";
		//执行sql
		qr.update(DataSourceUtils.getConnection(), sql, money,toUser);	
	}

}
