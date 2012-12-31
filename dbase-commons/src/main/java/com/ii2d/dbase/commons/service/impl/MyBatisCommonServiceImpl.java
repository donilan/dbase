//~ generate by eclipse
package com.ii2d.dbase.commons.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.ii2d.dbase.commons.service.CommonService;
import com.ii2d.dbase.mybatis.Page;
import com.ii2d.dbase.mybatis.SearchObject;
import com.ii2d.dbase.mybatis.dao.impl.CommonMyBatisDAO;

/**
 * @author Doni
 * @since 2012-9-17
 * @version $id$
 * 
 */
public class MyBatisCommonServiceImpl implements CommonService {
	
	protected CommonMyBatisDAO commonMyBatiesDAO;
	
	public CommonMyBatisDAO getCommonMyBatiesDAO() {
		return commonMyBatiesDAO;
	}

	public void setCommonMyBatiesDAO(CommonMyBatisDAO commonMyBatiesDAO) {
		this.commonMyBatiesDAO = commonMyBatiesDAO;
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#insert(java.lang.Object)
	 */
	@Override
	public int insert(Object o) {
		return commonMyBatiesDAO.insert(o);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#insert(java.util.Collection)
	 */
	@Override
	public int insert(Collection<?> objs) {
		return commonMyBatiesDAO.insert(objs);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#update(java.lang.Object)
	 */
	@Override
	public int update(Object o) {
		return commonMyBatiesDAO.update(o);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#delete(java.lang.Object, java.lang.Class)
	 */
	@Override
	public int delete(Object id, Class<?> clazz) {
		return commonMyBatiesDAO.delete(id, clazz);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#selectById(java.lang.Object, java.lang.Class)
	 */
	@Override
	public <T> T selectById(Object id, Class<?> clazz) {
		return commonMyBatiesDAO.selectById(id, clazz);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#select(com.ii2d.dbase.mybatis.SearchObject, java.lang.Class)
	 */
	@Override
	public <E> Page<E> select(SearchObject o, Class<?> clazz) {
		return commonMyBatiesDAO.select(o, clazz);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#select(java.lang.String, com.ii2d.dbase.mybatis.SearchObject)
	 */
	@Override
	public <E> Page<E> select(String sqlMapId, SearchObject o) {
		return commonMyBatiesDAO.select(sqlMapId, o);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#selectOne(java.lang.String)
	 */
	@Override
	public <T> T selectOne(String statement) {
		return commonMyBatiesDAO.selectOne(statement);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#selectOne(java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> T selectOne(String statement, Object parameter) {
		return commonMyBatiesDAO.selectOne(statement, parameter);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#selectMap(java.lang.String, java.lang.String)
	 */
	@Override
	public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
		return commonMyBatiesDAO.selectMap(statement, mapKey);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#selectMap(java.lang.String, java.lang.Object, java.lang.String)
	 */
	@Override
	public <K, V> Map<K, V> selectMap(String statement, Object parameter,
			String mapKey) {
		return commonMyBatiesDAO.selectMap(statement, parameter, mapKey);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#selectMap(java.lang.String, java.lang.Object, java.lang.String, org.apache.ibatis.session.RowBounds)
	 */
	@Override
	public <K, V> Map<K, V> selectMap(String statement, Object parameter,
			String mapKey, RowBounds rowBounds) {
		return commonMyBatiesDAO.selectMap(statement, parameter, mapKey,
				rowBounds);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#selectList(java.lang.String)
	 */
	@Override
	public <E> List<E> selectList(String statement) {
		return commonMyBatiesDAO.selectList(statement);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#selectList(java.lang.String, java.lang.Object)
	 */
	@Override
	public <E> List<E> selectList(String statement, Object parameter) {
		return commonMyBatiesDAO.selectList(statement, parameter);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#selectList(java.lang.String, java.lang.Object, org.apache.ibatis.session.RowBounds)
	 */
	@Override
	public <E> List<E> selectList(String statement, Object parameter,
			RowBounds rowBounds) {
		return commonMyBatiesDAO.selectList(statement, parameter, rowBounds);
	}
	
	public <E> List<E> selectList(SearchObject o, Class<?> clazz) {
		return commonMyBatiesDAO.selectList(o, clazz);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#select(java.lang.String, org.apache.ibatis.session.ResultHandler)
	 */
	@Override
	public void select(String statement, ResultHandler handler) {
		commonMyBatiesDAO.select(statement, handler);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#select(java.lang.String, java.lang.Object, org.apache.ibatis.session.ResultHandler)
	 */
	@Override
	public void select(String statement, Object parameter, ResultHandler handler) {
		commonMyBatiesDAO.select(statement, parameter, handler);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#select(java.lang.String, java.lang.Object, org.apache.ibatis.session.RowBounds, org.apache.ibatis.session.ResultHandler)
	 */
	@Override
	public void select(String statement, Object parameter, RowBounds rowBounds,
			ResultHandler handler) {
		commonMyBatiesDAO.select(statement, parameter, rowBounds, handler);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#insert(java.lang.String)
	 */
	@Override
	public int insert(String statement) {
		return commonMyBatiesDAO.insert(statement);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#insert(java.lang.String, java.lang.Object)
	 */
	@Override
	public int insert(String statement, Object parameter) {
		return commonMyBatiesDAO.insert(statement, parameter);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#update(java.lang.String)
	 */
	@Override
	public int update(String statement) {
		return commonMyBatiesDAO.update(statement);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#update(java.lang.String, java.lang.Object)
	 */
	@Override
	public int update(String statement, Object parameter) {
		return commonMyBatiesDAO.update(statement, parameter);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#delete(java.lang.String)
	 */
	@Override
	public int delete(String statement) {
		return commonMyBatiesDAO.delete(statement);
	}

	/* (non-Javadoc)
	 * @see com.ii2d.dbase.commons.service.impl.CommonService#delete(java.lang.String, java.lang.Object)
	 */
	@Override
	public int delete(String statement, Object parameter) {
		return commonMyBatiesDAO.delete(statement, parameter);
	}

	public Long count(SearchObject o, Class<?> clazz) {
		return commonMyBatiesDAO.count(o, clazz);
	}

	
}