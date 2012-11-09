//~ generate by eclipse
package com.ii2d.dbase.mybatis.dialect;

/**
 * @author Doni
 * @since 2012-11-9
 * @version $id$
 * 
 */
public interface Dialect {
	
	public boolean supportsLimit();
	
	public String getLimitString(String sql, int offset, int limit);

}
