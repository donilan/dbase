package com.ii2d.dbase.mybatis.dialect.db;


import com.ii2d.dbase.mybatis.SearchObject;
import com.ii2d.dbase.mybatis.dialect.Dialect;


public class MySQLDialect implements Dialect {

	@Override
	public String getLimitString(String _sql, SearchObject _so) {
		StringBuilder sb = new StringBuilder(256);
		sb.append(_sql).append(" LIMIT ");
		if(_so.getOffset() > 0) {
			sb.append(_so.getOffset()).append(", ").append(_so.getLimit());
		} else {
			sb.append(_so.getLimit());
		}
		return sb.toString();
	}

	public boolean supportsLimit() {
		return true;
	}
}
