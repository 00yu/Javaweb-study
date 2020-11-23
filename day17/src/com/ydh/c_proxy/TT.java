package com.ydh.c_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TT {
	public static void main(String[] args) {
		QQ qq=new QQ();
		//qq.run();
		//qq.stop();
		//创建代理对象
		Car qqProxy=(Car) Proxy.newProxyInstance(QQ.class.getClassLoader(), new Class[] {Car.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//System.out.println("哈哈");
				//System.out.println(method.getName());
				//obj就是被代理对象，args当前方法需要参数
				//return method.invoke(qq);
				//只对run方法进行加强
				if("run".equals(method.getName())) {
					System.out.println("加上电池，5s破百");
					return method.invoke(qq);
				}
				return method.invoke(qq);
			}
		});
		qqProxy.run();
		qqProxy.stop();
	}
}
