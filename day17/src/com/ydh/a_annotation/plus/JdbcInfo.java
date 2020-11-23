package com.ydh.a_annotation.plus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface JdbcInfo {
	String driverClass() default "com.mysql.cj.jdbc.Driver";//没有使用默认值
	String url();
	String username() default "root";
	String password() default "123";
}
