package com.ydh.service;

import java.sql.SQLException;
import java.util.List;

import com.ydh.dao.CityDao;
import com.ydh.domain.City;

public class CityService {

	public List<City> findCitiesByPid(String pid) throws SQLException {
		// 通过省份id查询所有的市
		return new CityDao().findCitiesByPid(pid);
	}

}
