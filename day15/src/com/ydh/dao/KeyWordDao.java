package com.ydh.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.ydh.utils.DataSourceUtils;

public class KeyWordDao {

	public List<Object> findKw4Ajax(String kw) throws SQLException {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select kw from keyword where kw like ? limit 5";
		return (List<Object>) qr.query(sql, new ColumnListHandler("kw"),"%"+kw+"%");
	}

}
