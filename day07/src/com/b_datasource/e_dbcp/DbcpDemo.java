package com.b_datasource.e_dbcp;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import com.utils.JdbcUtils;

public class DbcpDemo {
	//硬编码
	@Test
	public void f1() throws Exception {
		//创建连接池
		BasicDataSource ds=new BasicDataSource();
		//配置信息
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/day07?useSSL=true&serverTimezone=Asia/Shanghai");
		ds.setUsername("root");
		ds.setPassword("123");
		
		Connection conn=ds.getConnection();
		String sql="insert into category values(?,?)";
		PreparedStatement st=conn.prepareStatement(sql);
		st.setString(1, "c011");
		st.setString(2, "饮料");
		
		int i=st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResource(conn, st);
	}
	@Test
	public void f2() throws Exception {
		//存放配置文件
		Properties prop=new Properties();
		//设置
		//prop.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
		prop.load(new FileInputStream("src/dbcp.properties"));
		//创建连接池
		DataSource ds=new BasicDataSourceFactory().createDataSource(prop);
		Connection conn=ds.getConnection();
		String sql="insert into category values(?,?)";
		PreparedStatement st=conn.prepareStatement(sql);
		st.setString(1, "c013");
		st.setString(2, "饮料");
		
		int i=st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResource(conn, st);
	}
}
