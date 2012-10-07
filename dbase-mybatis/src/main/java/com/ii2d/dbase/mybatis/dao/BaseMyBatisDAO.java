package com.ii2d.dbase.mybatis.dao;

import java.util.List;

import com.ii2d.dbase.mybatis.Page;
import com.ii2d.dbase.mybatis.model.BaseMyBatisModel;

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
	int insert(BaseMyBatisModel o);
	
	/**
	 * update an object
	 */
	int update(BaseMyBatisModel o);
	
	@SuppressWarnings("rawtypes")
	int delete(Object id, Class clazz);
	
	/**
	 * query an object by id
	 * @author Doni
	 * @since 2012-9-9
	 */
	<T> T queryForById(Object id, Class<?> clazz);
	
	/**
	 * count objects from a table
	 * @author Doni
	 * @since 2012-9-9
	 */
	Long count(BaseMyBatisModel o);
	
	/**
	 * @see #queryForList(String, Object)
	 * @author Doni
	 * @since 2012-9-9
	 */
	<T> List<T> queryForList(BaseMyBatisModel o);
	
	/**
	 *
	 * @author Doni
	 * @since 2012-9-9
	 * @return
	 */
	Page queryForPage(BaseMyBatisModel o, int page, int rows);
	
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
