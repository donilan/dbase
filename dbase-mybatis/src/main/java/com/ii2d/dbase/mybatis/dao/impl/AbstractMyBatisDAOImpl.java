package com.ii2d.dbase.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.util.Assert;

import com.ii2d.dbase.mybatis.dao.BaseMyBatisDAO;
import com.ii2d.dbase.mybatis.model.BaseMyBatisModel;

/**
 * Base mybatis dao impl
 * 
 * @author Doni
 * @since 2012-09-09
 * @version $id$
 */
public abstract class AbstractMyBatisDAOImpl implements BaseMyBatisDAO {

	public static final String METHOD_INSERT = "insert";
	public static final String METHOD_UPDATE = "update";
	public static final String METHOD_DELETE = "delete";
	public static final String METHOD_SELECT = "select";
	public static final String METHOD_SELECT_BY_ID = "select_by_id";
	public static final String METHOD_COUNT = "count";

	protected org.apache.ibatis.session.SqlSession sqlSession;

	@Override
	public int insert(BaseMyBatisModel o) {
		return (Integer)sqlSession.insert(_getSqlMapId(METHOD_INSERT, o), o);
	}

	@Override
	public int update(BaseMyBatisModel o) {
		Assert.notNull(o);
		return sqlSession.update(_getSqlMapId(METHOD_UPDATE, o), o);
	}

	@Override
	public int delete(Object id, Class clazz) {
		Assert.notNull(clazz);
		Assert.notNull(id);
		return sqlSession.update(_getSqlMapId(METHOD_DELETE, clazz), id);
	}

	@Override
	public <T> List<T> queryForList(BaseMyBatisModel o) {
		Assert.notNull(o);
		return queryForList(_getSqlMapId(METHOD_SELECT, o), o);
	}

	@Override
	public <T> List<T> queryForList(BaseMyBatisModel o, int page, int rows) {
		Assert.notNull(o);
		if (page < 1)
			page = 1;
		if (rows < 1)
			rows = 10;
		o.limitStartRow((page-1)*rows);
		o.limitEndRow(page*rows);
		return queryForList(_getSqlMapId(METHOD_SELECT, o), o, page, rows);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T queryForById(Object id, Class<?> clazz) {
		return (T) sqlSession.selectOne(
				_getSqlMapId(METHOD_SELECT_BY_ID, clazz), id);
	}

	@Override
	public Long count(BaseMyBatisModel o) {
		return (Long) sqlSession.selectOne(_getSqlMapId(METHOD_COUNT, o), o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> queryForList(String sqlMapId, Object o) {
		Assert.notNull(o);
		return (List<T>) sqlSession.selectList(
				_getSqlMapId(METHOD_SELECT, o.getClass()), o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> queryForList(String sqlMapId, Object o, int page,
			int rows) {
		Assert.notNull(o);
		if (page < 1)
			page = 1;
		if (rows < 1)
			rows = 10;
		
		return sqlSession.selectList(_getSqlMapId(METHOD_SELECT, o.getClass()),
				o);
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/**
	 * method for get sql map id
	 * 
	 * @author Doni
	 * @since 2012-9-9
	 * @param method
	 *            - sql map method
	 * @param clazz
	 *            - class
	 * @return example insert_Object
	 */
	protected String _getSqlMapId(String method, BaseMyBatisModel o) {
		if (o == null) {
			throw new RuntimeException("Param object cann't be null.");
		}
		return _getSqlMapId(method, o.getClass());
	}

	protected String _getSqlMapId(String method, Class<?> clazz) {
		if (clazz == null || Object.class.equals(clazz))
			throw new RuntimeException(
					"Param clazz cann't be null or equals Object class.");
		return String.format("%s_%s", method, clazz.getSimpleName());
	}
}
