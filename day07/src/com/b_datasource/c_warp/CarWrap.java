package com.b_datasource.c_warp;

public class CarWrap implements Car {
	
	private Car car;

	public CarWrap(Car car) {
		this.car=car;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("加上电池");
		System.out.println("我终于可以5s破百了..");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		car.stop();
	}

}
