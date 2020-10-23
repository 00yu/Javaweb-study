package com.ydh.service;

import java.sql.SQLException;

import com.ydh.dao.UserDao;
import com.ydh.domain.User;

public class UserService {

	public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
		return new UserDao().getUserByUsernameAndPwd(username, password);
	}
	
}
