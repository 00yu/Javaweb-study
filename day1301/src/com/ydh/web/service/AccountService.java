package com.ydh.web.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.ydh.utils.JdbcUtils;
import com.ydh.web.dao.AccountDao;

public class AccountService {

	public void account(String fromUser, String toUser, String money) throws Exception{
		AccountDao dao=new AccountDao();
		//0.开启事务
		Connection conn=JdbcUtils.getConnection();
		try {
			conn.setAutoCommit(false);
			//1.转出
			dao.accountOut(conn,fromUser,money);
			//int i=1/0;
			//2.转入
			dao.accountIn(conn,toUser,money);
			//3.事务提交
			conn.commit();
			JdbcUtils.closeConn(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//事务回滚
			conn.rollback();
			JdbcUtils.closeConn(conn);
			throw e;	
		}
	}

}
