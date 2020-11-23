package com.ydh.service;

import java.sql.SQLException;

import com.ydh.dao.UserDao;
import com.ydh.domain.User;

public class UserService {

	public User checkUsername4Ajax(String username) throws SQLException {
		// 检测用户名是否被占用
		return new UserDao().getUserByUsername4Ajax(username);
	}

}
