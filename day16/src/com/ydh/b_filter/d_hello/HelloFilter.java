package com.ydh.b_filter.d_hello;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("过滤器HelloFilter收到了请求");
		//放行
		chain.doFilter(request, response);
		System.out.println("过滤器HelloFilter收到了响应");
	}

	@Override
	public void destroy() {
		
	}

}
