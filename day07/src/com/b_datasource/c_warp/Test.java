package com.b_datasource.c_warp;

public class Test {
	public static void main(String[] args) {
		QQ qq=new QQ();
//		qq.run();
//		qq.stop();
		
		CarWrap wrap=new CarWrap(qq);
		wrap.run();
		wrap.stop();
	}
}
