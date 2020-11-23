package com.ydh.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ydh.domain.Province;
import com.ydh.utils.DataSourceUtils;

public class ProvinceDao {

	public List<Province> findAll() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from province";
		return qr.query(sql, new BeanListHandler<>(Province.class));
	}

}
