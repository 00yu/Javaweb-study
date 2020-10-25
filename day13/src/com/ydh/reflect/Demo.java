package com.ydh.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import com.ydh.domain.Person;

public class Demo {
	@Test
	public void f1() throws Exception{
		//1.获取class对象
		Class clazz=Class.forName("com.ydh.domain.Person");
		//2.获取构造器(了解)
		Constructor con=clazz.getConstructor();
		Person p=(Person) con.newInstance();
		Constructor conn=clazz.getConstructor(String.class,String.class);
		Person pp=(Person) conn.newInstance("tom","123");
		System.out.println(pp.getPassword());
	}
	@Test
	public void f2() throws Exception{
		//1.获取class对象
		Class clazz=Class.forName("com.ydh.domain.Person");
		//2.获取构造器(了解)
		Person p=(Person) clazz.newInstance();
	}
	//获取私有方法
	@Test
	public void f3() throws Exception{
		//1.获取class对象
		Class clazz=Class.forName("com.ydh.domain.Person");
		//2.获取方法
		//Method m=clazz.getMethod("sleep");只能获取公共的方法
		Method m=clazz.getDeclaredMethod("sleep");//获取任意的方法(包括私有的方法)
		//2.1若是私有的方法，必须让该方法可以被访问
		m.setAccessible(true);
		m.invoke(clazz.newInstance());
	}
	@Test
	public void f11() throws Exception{
		//1.获取class对象
		Class clazz=Class.forName("com.ydh.domain.Person");
		//2.获取私有的方法
		Method m=clazz.getDeclaredMethod("sleep", String.class);
		m.setAccessible(true);
		//3.让方法执行
		String res=(String) m.invoke(clazz.newInstance(),"tom");
		System.out.println(res);
	}
}
