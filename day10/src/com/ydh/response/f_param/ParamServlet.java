package com.ydh.response.f_param;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取username
		String username=request.getParameter("username");
		System.out.println("username："+username);
		//获取爱好-多个值
		String[] hobby=request.getParameterValues("hobby");
		System.out.println("hobby："+Arrays.toString(hobby));
		//获取所有
		Map<String,String[]> map=request.getParameterMap();
		for (String key : map.keySet()) {
			System.out.println(key+"::"+Arrays.toString(map.get(key)));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
