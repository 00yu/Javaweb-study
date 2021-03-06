package com.example1;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.reflect.HelloMyServlet;

public class Demo {
	@Test
	public void f1() throws Exception {
		//定义一个map集合
		Map<String,String> map=new HashMap<>();
		//往map中放入一个值 key:/hello value:com.HelloMyServlet
		map.put("/hello", "com.reflect.HelloMyServlet");
		//通过key获取value
		String value=map.get("/hello");
		//通过全限定名创建一个实例
		Class clazz=Class.forName(value);
		HelloMyServlet a=(HelloMyServlet) clazz.newInstance();
		//调用空参的add方法
		Method method=clazz.getMethod("add");
		method.invoke(a);
	}
	
	@Test
	public void f2() throws Exception {
		//解析xml文件
		//创建document对象
		Document doc=new SAXReader().read("xml/web.xml");
		//通过xpath解析获取 servlet-class的标签体 和  url-pattern的标签体
		Node servletClass=doc.selectSingleNode("//servlet-class");
		Node urlpattern=doc.selectSingleNode("//url-pattern");
		String classText=servletClass.getText();
		String urlText=urlpattern.getText();
		//定义一个map集合
		Map<String,String> map=new HashMap<>();
		//将两个值放入map中
		map.put(urlText, classText);	
		//通过key获取value
		String value=map.get("/hello");
		//通过全限定名创建一个实例
		Class clazz=Class.forName(value);
		HelloMyServlet a=(HelloMyServlet) clazz.newInstance();
		//调用空参的add方法
		Method method=clazz.getMethod("add");
		method.invoke(a);
	}
}
