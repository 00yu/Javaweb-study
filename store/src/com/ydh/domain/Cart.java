package com.ydh.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart implements Serializable{
	//存放购物车项的集合(有序map集合，key为商品id，value为存放的购物车项，便于删除单个购物车项)
	private Map<String, CartItem> map=new LinkedHashMap<String, CartItem>();
	//总金额
	private Double total=0.0;
	//获取所有的购物车项 bean属性 用于jsp页面获取购物车项
	public Collection<CartItem> getItems(){
		return map.values();
	}
	//添加到购物车
	public void add2Cart(CartItem item) {
		//1.判断购物车中是否有该商品
		//1.1先获取商品id
		String pid=item.getProduct().getPid();
		if(map.containsKey(pid)) {
			//有
			//设置购买数量 需要获取该商品之前的购买数量+现在的购买数量
			CartItem Item_old=map.get(pid);
			Item_old.setCount(Item_old.getCount()+item.getCount());
		}else {
			//没有
			//将购物车项添加进去
			map.put(pid,item);
		}
		//2.添加完成之后修改金额
		total+=item.getSubtotal();
	}
	//从购物车中删除指定的购物车项
	public void removeFromCart(String pid) {
		//1.从集合中删除
		CartItem item = map.remove(pid);
		//2.修改金额
		total-=item.getSubtotal();
	}
	//清空购物车
	public void clearCart() {
		//1.将map置空
		map.clear();
		//2.金额置为0
		total=0.0;
	}
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
}
