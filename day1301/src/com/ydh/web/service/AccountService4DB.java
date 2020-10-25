package com.ydh.web.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.ydh.utils.DataSourceUtils;
import com.ydh.utils.JdbcUtils;
import com.ydh.web.dao.AccountDao;
import com.ydh.web.dao.AccountDao4DB;
import com.ydh.web.dao.AccountDao4tl;

public class AccountService4DB {

	public void account(String fromUser, String toUser, String money) throws Exception{
		AccountDao4DB dao=new AccountDao4DB();
		try {
			//0.开启事务
			DataSourceUtils.startTransaction();
			//将conn和当前线程绑定
			//1.转出
			dao.accountOut(fromUser,money);
			int i=1/0;
			//2.转入
			dao.accountIn(toUser,money);
			//3.事务提交
			DataSourceUtils.commitAndClose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//事务回滚
			DataSourceUtils.rollbackAndClose();
			throw e;	
		}
	}

}
