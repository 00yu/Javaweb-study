package com.ydh.web.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ydh.dao.CategoryDao;
import com.ydh.dao.ProductDao;
import com.ydh.dao.impl.CategoryDaoImpl;
import com.ydh.domain.Category;
import com.ydh.utils.BeanFactory;
import com.ydh.utils.DataSourceUtils;
import com.ydh.web.service.CategoryService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CategoryServiceImpl implements CategoryService {
	
	//查询所有的分类
	@Override
	public List<Category> findAll() throws Exception {
		//1.创建缓存管理器
		CacheManager cm=CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		//2.获取指定的缓存
		Cache cache = cm.getCache("categoryCache");//echache.xml起的名字name
		//3.通过缓存获取数据 将cache看成一个map集合
		Element element = cache.get("clist");
		//4.判断数据
		List<Category> list=null;
		if(element==null) {
			//缓存中无数据 从数据库中获取
			CategoryDao cd = new CategoryDaoImpl();
			list=cd.findAll();
			//将list放入缓存
			cache.put(new Element("clist", list));
		}else {
			//有的话拿出来
			list=(List<Category>) element.getObjectValue();
		}
		return list;
	}
	
	//添加分类
	@Override
	public void add(Category category) throws Exception {
		//获取dao
		CategoryDao cd=(CategoryDao) BeanFactory.getBean("CategoryDao");
		cd.add(category);
		//更新缓存
		//1.创建缓存管理器
		CacheManager cm=CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		//2.获取指定的缓存
		Cache cache = cm.getCache("categoryCache");//echache.xml起的名字name
		//3.清空缓存
		cache.remove("clist");
	}
	
	//通过cid获取一个分类对象
	@Override
	public Category getById(String cid) throws Exception {
		//获取dao
		CategoryDao cd=(CategoryDao) BeanFactory.getBean("CategoryDao");
		return cd.getById(cid);
	}

	//更新分类
	@Override
	public void update(Category category) throws Exception {
		//获取dao
		CategoryDao cd=(CategoryDao) BeanFactory.getBean("CategoryDao");
		cd.update(category);
		//清空缓存
		//1.创建缓存管理器
		CacheManager cm=CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		//2.获取指定的缓存
		Cache cache = cm.getCache("categoryCache");//echache.xml起的名字name
		//3.清空缓存
		cache.remove("clist");
	}

	//删除分类
	@Override
	public void delete(String cid) throws Exception {
		try {
			//1.开启事务
			DataSourceUtils.startTransaction();
			//2.更新商品信息
			ProductDao pd=(ProductDao) BeanFactory.getBean("ProductDao");
			pd.updateCid(cid);
			//3.删除分类
			CategoryDao cd=(CategoryDao) BeanFactory.getBean("CategoryDao");
			cd.delete(cid);
			//4.事务控制
			DataSourceUtils.commitAndClose();
			//5.清空缓存
			//1.创建缓存管理器
			CacheManager cm=CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
			//2.获取指定的缓存
			Cache cache = cm.getCache("categoryCache");//echache.xml起的名字name
			//3.清空缓存
			cache.remove("clist");
		} catch (SQLException e) {
			e.printStackTrace();
			DataSourceUtils.rollbackAndClose();
			throw e;
		}
	}

}
