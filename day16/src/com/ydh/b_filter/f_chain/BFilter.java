package com.ydh.b_filter.f_chain;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("BFilter收到请求");
		//放行
		chain.doFilter(request, response);
		System.out.println("BFilter收到响应");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
