package com.ydh.myAnno;

import com.ydh.myAnno.myenum.Color;

public @interface MyAnnotation2 {
	//注解属性
	int i();
	String s();
	String[] ss();
	Class cl();
	MyAnnotation1 m1();
	Color RED();
}
