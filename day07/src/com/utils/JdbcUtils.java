package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
//工具类
public class JdbcUtils {
	private JdbcUtils() {}
	private static final Connection conn;
	private static final String DRIVERCLASS;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;
	static {
		try {
//		通过ResourceBundle工具快速获取配置信息	
//		ResourceBundle bundle=ResourceBundle.getBundle("database");
//		DRIVERCLASS=bundle.getString("driverClass");
//		URL=bundle.getString("url");
//		USERNAME=bundle.getString("username");
//		PASSWORD=bundle.getString("password");
		//加载properties配置文件
		//IO读取文件，键值对存储到集合
		//从集合中以键值对方式获取数据库的连接信息，完成数据库的连接
		//使用类的加载器，读取bin文件中复制的一份配置文件
		InputStream in=JdbcUtils.class.getClassLoader().getResourceAsStream("database.properties");
		Properties pro=new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DRIVERCLASS=pro.getProperty("driverClass");
		URL=pro.getProperty("url");
		USERNAME=pro.getProperty("username");
		PASSWORD=pro.getProperty("password");
		//注册驱动
		Class.forName(DRIVERCLASS);
		//获取连接 ctrl+o导包
		conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		}catch(Exception e) {
			throw new RuntimeException(e+"数据库连接失败");
		}
	}
	
	//获取连接
	public static Connection getConnection() {
		return conn;
	}
	
	//释放资源
	public static void closeResource(Connection conn,Statement st,ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}
	
	public static void closeResource(Connection conn,Statement st) {
		closeStatement(st);
		closeConn(conn);
	}
	
	/** 
	 *释放连接
	 *@param conn 连接
	 *
	 */
	public static void closeConn(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn=null;
		}
	}
	/** 
	 *释放语句执行者
	 *@param st 语句执行者
	 *
	 */
	public static void closeStatement(Statement st) {
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st=null;
		}
	}
	/** 
	 *释放结果集
	 *@param rs 结果集
	 *
	 */
	public static void closeResultSet(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs=null;
		}
	}
}
