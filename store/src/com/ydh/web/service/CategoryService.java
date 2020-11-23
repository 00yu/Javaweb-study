package com.ydh.web.service;

import java.util.List;

import com.ydh.domain.Category;

public interface CategoryService {

	List<Category> findAll() throws Exception;

	void add(Category category) throws Exception;

	Category getById(String cid) throws Exception;

	void update(Category category) throws Exception;

	void delete(String cid) throws Exception;

}
