package com.reflect.Demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import com.reflect.HelloMyServlet;

public class Demo {
	@Test
	public void f1() {
		//调用HelloMyServlet中的方法
		HelloMyServlet a=new HelloMyServlet();
		a.add();
		a.add(10, 20);
	}
	@Test
	public void f2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz=Class.forName("com.reflect.HelloMyServlet");
		//通过字节码对象创建一个实例对象
		HelloMyServlet a=(HelloMyServlet) clazz.newInstance();
		a.add();
	}
	//调用空参的add方法
	@Test
	public void f3() throws Exception{
		//获取class对象
		Class clazz=Class.forName("com.reflect.HelloMyServlet");
		//通过字节码对象创建一个实例对象
		HelloMyServlet a=(HelloMyServlet) clazz.newInstance();
		//获取一个方法对象
		Method method=clazz.getMethod("add");
		//让方法对象执行 (调用这个方法的对象,该方法执行时所需要的参数)
		method.invoke(a);//相当于a.add()
	}
	//调用两个参数的add方法
	@Test
	public void f4() throws Exception{
		//获取class对象
		//Class clazz=Class.forName("com.reflect.HelloMyServlet");
		Class clazz=HelloMyServlet.class;
		//通过字节码对象创建一个实例对象
		HelloMyServlet a=(HelloMyServlet) clazz.newInstance();
		//获取两个参数的add方法
		Method method=clazz.getMethod("add",int.class,int.class);
		//让方法对象执行 (调用这个方法的对象,该方法执行时所需要的参数)
		method.invoke(a,10,30);//相当于a.add(10,30)
	}
}

