package com.ydh.domain;

import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String password;
	private String username;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return username;
	}
	public void setName(String username) {
		this.username = username;
	}
}
