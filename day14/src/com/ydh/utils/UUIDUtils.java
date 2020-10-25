package com.ydh.utils;

import java.util.UUID;

//生成不重复id
public class UUIDUtils {
	//随机生成ID
	public static String getId() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	////随机生成令牌随机码
	public static String getCode() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
}
