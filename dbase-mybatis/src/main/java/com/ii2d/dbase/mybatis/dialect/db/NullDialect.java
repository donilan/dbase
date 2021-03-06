//~ generate by eclipse
package com.ii2d.dbase.mybatis.dialect.db;


import com.ii2d.dbase.mybatis.SearchObject;
import com.ii2d.dbase.mybatis.dialect.Dialect;

/**
 * @author Doni
 * @since 2012-11-9
 * @version $id$
 * 
 */
public class NullDialect implements Dialect {

	@Override
	public boolean supportsLimit() {
		return false;
	}

	@Override
	public String getLimitString(String sql, SearchObject rowBounds) {
		return sql;
	}

}
