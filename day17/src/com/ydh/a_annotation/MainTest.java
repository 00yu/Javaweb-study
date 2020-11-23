package com.ydh.a_annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTest {
	/*
	 * public static void main(String[] args) { //运行这个类的时候需要将测试类中带有@MyTest的所有方法执行
	 * //获取字节码对象 Class clazz=MyTestTest.class; //获取所有的方法 Method[]
	 * arr=clazz.getMethods(); //让方法执行 for (Method m : arr) { //打印所有方法的名称
	 * System.out.println(m.getName()); } }
	 */
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// 获取字节码对象
		Class clazz = MyTestTest.class;
		// 获取所有的方法 Method[]
		Method[] arr = clazz.getMethods();
		//让带有注解的方法执行
		for (Method m : arr) {
			//获取有注解的方法
			//判断方法是否有指定的注解
			boolean flag=m.isAnnotationPresent(MyTest.class);
			if(flag) {
				//System.out.println(m.getName());
				m.invoke(clazz.newInstance());
			}
		}
	}
}
