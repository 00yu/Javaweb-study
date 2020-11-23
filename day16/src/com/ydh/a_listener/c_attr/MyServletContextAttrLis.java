package com.ydh.a_listener.c_attr;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttrLis implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		//添加
		System.out.println("在servletcontext中添加了一个属性,属性为："+scae.getName());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		//删除
		System.out.println("在servletcontext中移除了一个属性,属性为："+scae.getName());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		//替换
		System.out.println("在servletcontext中替换了一个属性,属性为："+scae.getName());
	}

}
