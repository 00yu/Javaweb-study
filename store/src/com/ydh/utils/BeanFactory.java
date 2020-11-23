package com.ydh.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 实体工厂类
 * @author yudonghai
 *
 */
public class BeanFactory {
	public static Object getBean(String id) {
		//通过id获取一个指定的实现类
		//导入jar包(dom4j-2.1.1.jar和jaxen-1.1.1.jar) xpath解析技术
		try {
			//1.获取document对象
			Document doc=new SAXReader().read(BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml"));
			//2.获取指定的bean对象
			Element ele=(Element) doc.selectSingleNode("//bean[@id='"+id+"']");
			//3.获取bean对象的class属性
			String value = ele.attributeValue("class");
			//4.反射 以前的逻辑直接返回的是实例
			//return Class.forName(value).newInstance();
			//5.现在对service中的add方法进行加强 返回的是代理对象
			Object obj = Class.forName(value).newInstance();
			//判断是否为service方法
			if(id.endsWith("Service")) {
				Object proxyObj = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//继续判断是否调用的是add或regist方法
						if("add".equals(method.getName()) || "regist".equals(method.getName())) {
							System.out.println("添加操作~~~");
							return method.invoke(obj, args);
						}
						return method.invoke(obj, args);
					}
				});
				//若是service方法返回的是代理对象
				return proxyObj;
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
