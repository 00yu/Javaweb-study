package com.ydh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ydh.web.service.AccountService;
import com.ydh.web.service.AccountService4DB;
import com.ydh.web.service.AccountService4tl;

/**
 * 转账
 */
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w=response.getWriter();
		//1.接收三个参数
		String fromUser=request.getParameter("fromuser");
		String toUser=request.getParameter("touser");
		String money=request.getParameter("money");
		//2.调用accountservice.account(fromuser,touser,money)
		try {
			//使用的threadlocal
			//new AccountService4tl().account(fromUser,toUser,money);
			new AccountService4DB().account(fromUser,toUser,money);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			w.print("转账失败");
			return;
		}
		//3.打印信息
		w.print("转账成功");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
