package com.ydh.a_annotation.plus;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	@JdbcInfo(url = "jdbc:mysql://localhost:3306/day07?useSSL=true&serverTimezone=Asia/Shanghai")
	public static Connection getConnection() throws NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		//1.获取字节码文件
		Class clazz=JdbcUtils.class;
		//2.获取getConnection()
		Method m=clazz.getMethod("getConnection");
		//3.判断该方法是否有JdbcInfo注解 若有的话获取
		if(m.isAnnotationPresent(JdbcInfo.class)) {	
			JdbcInfo info=m.getAnnotation(JdbcInfo.class);	
			//4.获取注解四个属性
			String driverClass=info.driverClass();
			String url=info.url();
			String username=info.username();
			String password=info.password();
			//5.注册驱动
			Class.forName(driverClass);
			//6.获取连接
			return DriverManager.getConnection(url, username, password);
		}
		return null;
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		System.out.println(getConnection());
	}
}
