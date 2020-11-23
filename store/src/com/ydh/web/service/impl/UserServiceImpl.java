package com.ydh.web.service.impl;

import com.ydh.dao.UserDao;
import com.ydh.dao.impl.UserDaoImpl;
import com.ydh.domain.User;
import com.ydh.utils.MailUtils;
import com.ydh.web.service.UserService;

public class UserServiceImpl implements UserService {
	/**
	 * 用户注册
	 */
	@Override
	public void regist(User user) throws Exception{
		UserDao dao=new UserDaoImpl();
		dao.add(user);
		//发送邮件
		//email：收件人地址	emailMsg：邮件内容
		String emailMsg="欢迎您注册为我们的一员，<a href='http://localhost:8080/store/user?method=active&code="+user.getCode()+"'>点此激活</a>";
		MailUtils.sendMail(user.getEmail(), emailMsg);
	}
	/**
	 * 用户激活
	 * @throws Exception 
	 */
	@Override
	public User active(String code) throws Exception {
		UserDao dao=new UserDaoImpl();
		//1.通过code获取一个用户
		User user=dao.getByCode(code);
		//2.判断用户是否为空
		if(user==null) {
			return null;
		}
		//3.修改用户状态state
		//将用户的状态设置为1
		user.setState(1);
		dao.update(user);
		return user;
	}
	
	/**
	 * 用户登录
	 * @throws Exception 
	 */
	@Override
	public User login(String username, String password) throws Exception {
		UserDao dao=new UserDaoImpl();
		return dao.getByUsernameAndPwd(username,password);
	}
	
}
