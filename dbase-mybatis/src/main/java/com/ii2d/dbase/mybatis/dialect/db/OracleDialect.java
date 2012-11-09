package com.ii2d.dbase.mybatis.dialect.db;

import org.apache.ibatis.session.RowBounds;

import com.ii2d.dbase.mybatis.dialect.Dialect;


public class OracleDialect implements Dialect {
	@Override
	public boolean supportsLimit() {
		return true;
	}

	@Override
	public String getLimitString(String sql, RowBounds rowBounds) {
		return getLimitString(sql, rowBounds.getOffset(),
				Integer.toString(rowBounds.getOffset()),
				Integer.toString(rowBounds.getLimit()));
	}

	
	public String getLimitString(String sql, int offset,
			String offsetPlaceholder, String limitPlaceholder) {
		sql = sql.trim();
		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" for update")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}
		StringBuilder pagingSelect = new StringBuilder(sql.length() + 100);
		if (offset > 0) {
			pagingSelect
					.append("select * from ( select row_.*, rownum rownum_ from ( ");
		} else {
			pagingSelect.append("select * from ( ");
		}
		pagingSelect.append(sql);
		if (offset > 0) {
			String endString = offsetPlaceholder + "+" + limitPlaceholder;
			pagingSelect.append(" ) row_ ) where rownum_ <= ")
					.append(endString).append(" and rownum_ > ")
					.append(offsetPlaceholder);
		} else {
			pagingSelect.append(" ) where rownum <= ").append(limitPlaceholder);
		}

		if (isForUpdate) {
			pagingSelect.append(" for update");
		}

		return pagingSelect.toString();
	}

}
