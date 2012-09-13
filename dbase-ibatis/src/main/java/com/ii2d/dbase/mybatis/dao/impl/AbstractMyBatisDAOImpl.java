package com.ii2d.dbase.mybatis.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ii2d.dbase.mybatis.dao.BaseMyBatisDAO;

/**
 * Base mybatis dao impl
 * 
 * @author Doni
 * @since 2012-09-09
 * @version $id$
 */
public abstract class AbstractMyBatisDAOImpl implements BaseMyBatisDAO {

	protected static final String METHOD_INSERT = "insert";
	protected static final String METHOD_UPDATE = "update";
	protected static final String METHOD_DELETE = "delete";
	protected static final String METHOD_SELECT = "select";
	protected static final String METHOD_SELECT_ONE = "select_one";
	protected static final String METHOD_LIMIT_SELECT = "limit_select";
	protected static final String METHOD_COUNT = "count";

	protected org.apache.ibatis.session.SqlSession sqlSession;

	@Override
	public int insert(Object o) {
		return sqlSession.insert(_getSqlMapId(METHOD_INSERT, o), o);
	}

	@Override
	public int update(Object o) {
		return sqlSession.update(_getSqlMapId(METHOD_UPDATE, o), o);
	}

	@Override
	public int delete(Object o) {
		return sqlSession.update(_getSqlMapId(METHOD_DELETE, o), o);
	}

	@Override
	public <T> List<T> queryForList(Object o) {
		return queryForList(_getSqlMapId(METHOD_SELECT, o), o);
	}

	@Override
	public <T> List<T> queryForList(Object o, int page, int rows) {
		return queryForList(_getSqlMapId(METHOD_SELECT, o), o, page, rows);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T queryForOne(Object id, Class<?> clazz) {
		return (T) sqlSession.selectOne(_getSqlMapId(METHOD_SELECT_ONE, clazz), id);
	}

	@Override
	public Long count(Object o) {
		return (Long) sqlSession.selectOne(_getSqlMapId(METHOD_COUNT, o), o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> queryForList(String sqlMapId, Object o) {
		return (List<T>) sqlSession.selectList(_getSqlMapId(METHOD_SELECT, o),
				o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> queryForList(String sqlMapId, Object o, int page,
			int rows) {
		if (page < 1)
			page = 1;
		if (rows < 1)
			rows = 10;

		Map<String, Object> sMap = new HashMap<String, Object>();
		sMap.put("qObj", o);
		sMap.put("page", page);
		sMap.put("rows", rows);
		sMap.put("start_row", (page - 1) * rows);
		sMap.put("end_row", page * rows);

		return sqlSession
				.selectList(_getSqlMapId(METHOD_LIMIT_SELECT, o), sMap);
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
	protected String _getSqlMapId(String method, Object o) {
		if (o == null ) {
			throw new RuntimeException(
					"Param object cann't be null.");
		}
		return _getSqlMapId(method, o.getClass());
	}
	
	protected String _getSqlMapId(String method, Class<?> clazz) {
		if(clazz == null || Object.class.equals(clazz))
			throw new RuntimeException(
					"Param clazz cann't be null or equals Object class.");
		return String.format("%s_%s", method, clazz.getSimpleName());
	}
}
