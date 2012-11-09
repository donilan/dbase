package com.ii2d.dbase.mybatis.dialect.db;

import org.apache.ibatis.session.RowBounds;

import com.ii2d.dbase.mybatis.dialect.Dialect;


public class MySQLDialect implements Dialect {

	@Override
	public String getLimitString(String sql, RowBounds rowBounds) {
		StringBuilder sb = new StringBuilder(256);
		sb.append(sql).append(" LIMIT ");
		if(rowBounds.getOffset() > 0) {
			sb.append(rowBounds.getOffset()).append(", ").append(rowBounds.getLimit());
		} else {
			sb.append(rowBounds.getLimit());
		}
		return sb.toString();
	}

	public boolean supportsLimit() {
		return true;
	}
}
