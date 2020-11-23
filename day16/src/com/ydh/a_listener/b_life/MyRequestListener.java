package com.ydh.a_listener.b_life;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("请求已销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("请求已创建");
	}

}
