package com.ydh.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ydh.domain.City;
import com.ydh.utils.DataSourceUtils;

public class CityDao {

	public List<City> findCitiesByPid(String pid) throws SQLException {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from city where provinceid=?";
		return qr.query(sql, new BeanListHandler<>(City.class),pid);
	}

}
