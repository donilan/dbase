package com.ii2d.dbase.mybatis.dialect.db;


import com.ii2d.dbase.mybatis.SearchObject;
import com.ii2d.dbase.mybatis.dialect.Dialect;


public class OracleDialect implements Dialect {
	@Override
	public boolean supportsLimit() {
		return true;
	}

	@Override
	public String getLimitString(String sql, SearchObject rowBounds) {
		return getLimitString(sql, rowBounds.getOffset(),
				Integer.toString(rowBounds.getOffset()),
				Integer.toString(rowBounds.getLimit()));
	}

	
	public String getLimitString(String sql, int offset,
			String offsetPlaceholder, String limitPlaceholder) {
		sql = sql.trim();
		boolean isForUpdate = false;
		if (sql.toUpperCase().endsWith(" FROM UPDATE")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}
		StringBuilder pagingSelect = new StringBuilder(sql.length() + 100);
		if (offset > 0) {
			pagingSelect
					.append("SELECT * FROM ( SELECT ROW_TMP.*, ROWNUM ROWNUM_TMP FROM ( ");
		} else {
			pagingSelect.append("SELECT * FROM ( ");
		}
		pagingSelect.append(sql);
		if (offset > 0) {
			String endString = offsetPlaceholder + "+" + limitPlaceholder;
			pagingSelect.append(" ) ROW_TMP ) ")
				.append("WHERE ROWNUM_TMP <= ")
				.append(endString).append(" AND ROWNUM_TMP > ")
				.append(offsetPlaceholder);
		} else {
			pagingSelect.append(" ) WHERE ROWNUM <= ").append(limitPlaceholder);
		}

		if (isForUpdate) {
			pagingSelect.append(" FOR UPDATE");
		}

		return pagingSelect.toString();
	}

}
