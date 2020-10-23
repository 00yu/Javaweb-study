package com.ydh.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
	public static Cookie getCookieByName(String name, Cookie[] cookies) {
		//通过名称在cookie数组中获取指定的cookie
		if(cookies!=null) {
			for (Cookie c : cookies) {
				//通过名称获取
				if(name.equals(c.getName())) {
					return c;
				}
			}
		}
		return null;
	}
}
