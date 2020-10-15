package com.ydh.service;

import java.sql.SQLException;

import com.ydh.dao.UserDao;
import com.ydh.domain.User;
//处理业务逻辑
public class UserService {
	//用户登录方法 返回User
	public User login(String username, String password) throws SQLException {
		//调用dao
		UserDao dao=new UserDao();
		return dao.getUserByUsernameAndPwd(username,password);
	}

}
