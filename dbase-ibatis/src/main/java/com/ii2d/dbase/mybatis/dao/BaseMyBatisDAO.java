package com.ii2d.dbase.mybatis.dao;

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
	 * @return success return great than 0, fail return less than 0
	 */
	int insert(Object o);
	
	/**
	 * update an object
	 */
	int update(Object o);
	
	int delete(Object o);
	
	/**
	 * query an object by id
	 * @author Doni
	 * @since 2012-9-9
	 */
	<T> T queryForOne(Object id, Class<?> clazz);
	
	/**
	 * count objects from a table
	 * @author Doni
	 * @since 2012-9-9
	 */
	Long count(Object o);
	
	/**
	 * @see #queryForList(String, Object)
	 * @author Doni
	 * @since 2012-9-9
	 */
	<T> List<T> queryForList(Object o);
	
	/**
	 * @see #queryForList(String, Object, int, int)
	 * @author Doni
	 * @since 2012-9-9
	 * @return
	 */
	<T> List<T> queryForList(Object o, int page, int rows);
	
	/**
	 * 
	 * @author Doni
	 * @since 2012-9-9
	 * @param sqlMapId - sql map id
	 * @param o - query object
	 */
	<T> List<T> queryForList(String sqlMapId, Object o);
	/**
	 * 
	 * @author Doni
	 * @since 2012-9-9
	 * @param sqlMapId - sql map id
	 * @param o - query object
	 * @param page - page
	 * @param rows - rows of per page
	 * @return
	 */
	<T> List<T> queryForList(String sqlMapId, Object o, int page, int rows);
}
