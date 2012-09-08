package org.dbase.mybatis.dao;

import java.util.List;

/**
 * Base mybatis dao
 * @author Doni
 * @since 2012-09-09
 * @version $id$
 */
public interface BaseMyBatisDAO {

	/**
	 * Insert an object
	 */
	int insert(Object o);
	
	/**
	 * update an object
	 */
	int update(Object o);
	
	int delete(Object o);
	
	<T> List<T> queryForList(Object o);
	
	<T> List<T> queryForList(Object o, int page, int rows);
}
