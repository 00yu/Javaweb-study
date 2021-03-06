package com.b_datasource.f_c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.utils.JdbcUtils;

public class C3p0Demo {
	//硬编码
	@Test
	public void f1() throws Exception {
		ComboPooledDataSource ds=new ComboPooledDataSource();
		//设置基本参数
		ds.setDriverClass("com.mysql.cj.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/day07?useSSL=true&serverTimezone=Asia/Shanghai");
		ds.setUser("root");
		ds.setPassword("123");

		Connection conn=ds.getConnection();
		String sql="insert into category values(?,?)";
		PreparedStatement st=conn.prepareStatement(sql);
		st.setString(1, "c014");
		st.setString(2, "毒药");
		
		int i=st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResource(conn, st);
	}
	//配置文件
	@Test
	public void f2() throws Exception {
		//ComboPooledDataSource ds=new ComboPooledDataSource();
		ComboPooledDataSource ds=new ComboPooledDataSource("itcast");
		Connection conn=ds.getConnection();
		String sql="insert into category values(?,?)";
		PreparedStatement st=conn.prepareStatement(sql);
		st.setString(1, "c018");
		st.setString(2, "解药");
		
		int i=st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResource(conn, st);
	}
	
}
