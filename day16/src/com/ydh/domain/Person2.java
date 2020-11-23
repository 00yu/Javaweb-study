package com.ydh.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Person2 implements HttpSessionActivationListener,Serializable{
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
	public Person2(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Person2() {
	}
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		//钝化
		System.out.println("Person对象写入磁盘 钝化");
	}
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		//活化
		System.out.println("Person对象活化了");
	}
	
}
