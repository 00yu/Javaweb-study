package com.ydh.jsonlib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.ydh.domain.Province;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




public class Demo {
	@Test
	public void f1() {
		String[] arr= {"aaa","bbb","ccc"};
		JSONArray json=JSONArray.fromObject(arr);
		System.out.println(json);
	}
	@Test
	public void f2() {
		List<String> list=new ArrayList<>();
		list.add("111");
		list.add("222");
		list.add("333");
		JSONArray json=JSONArray.fromObject(list);
		System.out.println(json);
	}
	@Test
	public void f3() {
		Province pro=new Province();
		pro.setName("北京");
		pro.setProvinceid(1);
		JSONObject json=JSONObject.fromObject(pro);
		System.out.println(json);
	}
	@Test
	public void f4() {
		Map<String,Object> map=new HashMap<>();
		map.put("username", "tom");
		map.put("age", 18);
		JSONObject json=JSONObject.fromObject(map);
		System.out.println(json);
	}
	@Test
	public void f5() {
		List<Province> list=new ArrayList<Province>();
		list.add(new Province(1,"北京"));
		list.add(new Province(2,"天津"));
		list.add(new Province(3,"东京"));
		JSONArray json=JSONArray.fromObject(list);
		System.out.println(json);
	}
}
