package com.ii2d.dbase.mybatis.dao.impl;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.util.Assert;

import com.ii2d.dbase.mybatis.Page;
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
		return insert(_getSqlMapId(METHOD_INSERT, o), o);
	}

	@Override
	public int update(BaseMyBatisModel o) {
		return update(_getSqlMapId(METHOD_UPDATE, o), o);
	}
	
	@Override
	public int insert(Collection<? extends BaseMyBatisModel> objs) {
		if(objs == null || objs.isEmpty())
			return 0;
		for(BaseMyBatisModel o: objs)
			insert(o);
		return objs.size();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public int delete(Object id, Class clazz) {
		Assert.notNull(clazz);
		Assert.notNull(id);
		return sqlSession.update(_getSqlMapId(METHOD_DELETE, clazz), id);
	}

	@Override
	public <T> List<T> queryForList(BaseMyBatisModel o) {
		return sqlSession.selectList(_getSqlMapId(METHOD_SELECT, o), o, o.getRowBounds());
	}

	@Override
	public <T> Page<T> queryForPage(BaseMyBatisModel o, int page, int rows) {
		Assert.notNull(o);
		return queryForPage(_getSqlMapId(METHOD_SELECT, o), o, page, rows);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T queryForById(Object id, Class<?> clazz) {
		return (T) sqlSession.selectOne(
				_getSqlMapId(METHOD_SELECT_BY_ID, clazz), id);
	}

	@Override
	public Long count(BaseMyBatisModel o) {
		return query2Long(_getSqlMapId(METHOD_COUNT, o), o);
	}
	
	@Override
	public <T> T queryOne(String sqlMapId, Object searchObj) {
		List<T> list = queryForPage(sqlMapId, searchObj, 1, 1);
		if(list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> queryForList(String sqlMapId, Object o) {
		return (List<T>) sqlSession.selectList(sqlMapId, o);
	}

	@Override
	public <T> Page<T> queryForPage(String sqlMapId, Object o, int page,
			int rows) {
		if (page < 1)
			page = 1;
		if (rows < 1)
			rows = 10;

		return (Page<T>)sqlSession.selectList(sqlMapId, o, new RowBounds((page-1)*rows, rows));
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

	@Override
	public int insert(String sqlMapId, Object insertObj) {
		return (Integer) sqlSession.insert(sqlMapId, insertObj);
	}

	@Override
	public int update(String sqlMapId, Object updateObj) {
		Assert.notNull(updateObj);
		return sqlSession.update(sqlMapId, updateObj);
	}

	@Override
	public Long query2Long(String sqlMapId, Object searchObj) {
		return (Long) sqlSession.selectOne(sqlMapId, searchObj);
	}


}