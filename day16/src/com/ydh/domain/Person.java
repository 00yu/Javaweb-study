package com.ydh.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person implements HttpSessionBindingListener{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Person() {
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		//绑定到session中
		System.out.println("Person对象绑定到session中");
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		//从session中移除
		System.out.println("Person对象从session中移除了");
	}
	
}
