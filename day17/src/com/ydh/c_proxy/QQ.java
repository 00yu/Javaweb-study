package com.ydh.c_proxy;

public class QQ implements Car {

	@Override
	public void run() {
		System.out.println("QQ在跑");
	}

	@Override
	public void stop() {
		System.out.println("QQ刹车");
	}

}
