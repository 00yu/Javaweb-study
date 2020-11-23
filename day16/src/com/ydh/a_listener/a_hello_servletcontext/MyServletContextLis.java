package com.ydh.a_listener.a_hello_servletcontext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextLis implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//创建操作
		System.out.println("我们的servletcontext创建了");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//销毁操作
		System.out.println("我们的servletcontext销毁了");
	}
	
}
