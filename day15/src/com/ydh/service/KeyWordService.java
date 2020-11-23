package com.ydh.service;

import java.sql.SQLException;
import java.util.List;

import com.ydh.dao.KeyWordDao;

public class KeyWordService {

	public List<Object> findKw4Ajax(String kw) throws SQLException {
		// TODO Auto-generated method stub
		return new KeyWordDao().findKw4Ajax(kw);
	}

}
