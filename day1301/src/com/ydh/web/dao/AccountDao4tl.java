package com.ydh.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ydh.utils.DataSourceUtils;
import com.ydh.utils.JdbcUtils;

public class AccountDao4tl {

	public void accountOut_(String fromUser, String money) throws SQLException {
		// 转出
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		//创建语句执行者
		try {
			conn=JdbcUtils.getConnection();
			//编写sql
			String sql="update account set money = money - ? where name = ?";
			st=conn.prepareStatement(sql);
			//设置参数
			st.setString(1, money);
			st.setString(2, fromUser);
			//执行sql
			int i= st.executeUpdate();
			//处理结果
			System.out.println("出："+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally {
			//JdbcUtils.closeResource(conn, st, rs);
		}
	}

	public void accountIn_(String toUser, String money) throws SQLException {
		// 转入
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		//创建语句执行者
		try {
			conn=JdbcUtils.getConnection();
			//编写sql
			String sql="update account set money = money + ? where name = ?";
			st=conn.prepareStatement(sql);
			//设置参数
			st.setString(1, money);
			st.setString(2, toUser);
			//执行sql
			int i= st.executeUpdate();
			//处理结果
			System.out.println("入："+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally {
			//JdbcUtils.closeResource(conn, st, rs);
		}
	}

	public void accountOut(Connection conn, String fromUser, String money) throws SQLException {
		// 转出
		PreparedStatement st=null;
		//创建语句执行者
		try {
			//编写sql
			String sql="update account set money = money - ? where name = ?";
			st=conn.prepareStatement(sql);
			//设置参数
			st.setString(1, money);
			st.setString(2, fromUser);
			//执行sql
			int i= st.executeUpdate();
			//处理结果
			System.out.println("出："+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtils.closeStatement(st);
		}
		
	}

	public void accountIn(Connection conn, String toUser, String money) throws SQLException {
		// 转入
		PreparedStatement st=null;
		//创建语句执行者
		try {
			//编写sql
			String sql="update account set money = money + ? where name = ?";
			st=conn.prepareStatement(sql);
			//设置参数
			st.setString(1, money);
			st.setString(2, toUser);
			//执行sql
			int i= st.executeUpdate();
			//处理结果
			System.out.println("入："+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtils.closeStatement(st);
		}
		
	}

	public void accountOut(String fromUser, String money) throws SQLException {
		// 转出
		PreparedStatement st=null;
		Connection conn=null;
		ResultSet rs=null;
		//创建语句执行者
		try {
			conn=DataSourceUtils.getConnection();
			//编写sql
			String sql="update account set money = money - ? where name = ?";
			st=conn.prepareStatement(sql);
			//设置参数
			st.setString(1, money);
			st.setString(2, fromUser);
			//执行sql
			int i= st.executeUpdate();
			//处理结果
			System.out.println("出："+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally {
			DataSourceUtils.closeResource(st, rs);
		}
		
	}

	public void accountIn(String toUser, String money) throws SQLException {
		// 转入
		PreparedStatement st=null;
		Connection conn=null;
		ResultSet rs=null;
		//创建语句执行者
		try {
			conn=DataSourceUtils.getConnection();
			//编写sql
			String sql="update account set money = money + ? where name = ?";
			st=conn.prepareStatement(sql);
			//设置参数
			st.setString(1, money);
			st.setString(2, toUser);
			//执行sql
			int i= st.executeUpdate();
			//处理结果
			System.out.println("入："+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally {
			DataSourceUtils.closeResource(st, rs);
		}
		
	}

}
