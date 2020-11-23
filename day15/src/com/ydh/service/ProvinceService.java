package com.ydh.service;

import java.sql.SQLException;
import java.util.List;

import com.ydh.dao.ProvinceDao;
import com.ydh.domain.Province;

public class ProvinceService {

	public List<Province> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return new ProvinceDao().findAll();
	}

}
