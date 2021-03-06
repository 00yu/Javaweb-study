package com.b_datasource.b_my;

import java.sql.Connection;
import java.util.LinkedList;

import com.utils.JdbcUtils;

//简易自定义连接池
public class MyDataSource {
	static LinkedList<Connection> pool=new LinkedList<>();
	static {
		//初始化的时候需要放入3个连接
		for(int i=0;i<3;i++) {
			Connection conn=JdbcUtils.getConnection();
			pool.addLast(conn);
		}
	}
	//从连接池中获取连接的方法
	public static Connection getConnection() {
		//获取连接的时候需要判断list是否为空
		if(pool.isEmpty()) {
			//再添加3个连接进去
			for(int i=0;i<3;i++) {
				Connection conn=JdbcUtils.getConnection();
				pool.addLast(conn);
			}
		}
		System.out.println("从连接池中获取一个连接");
		return pool.removeFirst();
	}
	//归还连接的方法
	public static void addBack(Connection conn) {
		//将conn放入到list的最后面即可
		pool.addLast(conn);
		System.out.println("连接已归还");
	}
}
