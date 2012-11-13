package com.ii2d.dbase.mybatis.dao.impl;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.support.PersistenceExceptionTranslator;

import com.ii2d.dbase.mybatis.Page;
import com.ii2d.dbase.mybatis.PaginationResultHandler;
import com.ii2d.dbase.mybatis.SearchObject;
import com.ii2d.dbase.mybatis.dao.BaseMyBatisDAO;

/**
 * Base mybatis dao impl
 * 
 * @author Doni
 * @since 2012-09-09
 * @version $id$
 */
public abstract class AbstractMyBatisDAOImpl extends SqlSessionTemplate implements BaseMyBatisDAO {

	public static final String METHOD_INSERT = "insert";
	public static final String METHOD_UPDATE = "update";
	public static final String METHOD_DELETE = "delete";
	public static final String METHOD_SELECT = "select";
	public static final String METHOD_SELECT_BY_ID = "select_by_id";
	public static final String METHOD_COUNT = "count";

	public AbstractMyBatisDAOImpl(SqlSessionFactory sqlSessionFactory,
			ExecutorType executorType,
			PersistenceExceptionTranslator exceptionTranslator) {
		super(sqlSessionFactory, executorType, exceptionTranslator);
	}

	public AbstractMyBatisDAOImpl(SqlSessionFactory sqlSessionFactory,
			ExecutorType executorType) {
		super(sqlSessionFactory, executorType);
	}

	public AbstractMyBatisDAOImpl(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}

	public int insert(Object o) {
		return insert(_getSqlMapId(METHOD_INSERT, o), o);
	}
	public int insert(Collection<?> objs) {
		if(objs == null || objs.isEmpty())
			return 0;
		for(Object o: objs)
			insert(o);
		return objs.size();
	}
	
	public int update(Object o) {
		return update(_getSqlMapId(METHOD_UPDATE, o), o);
	}
	
	public int delete(Object id, Class<?> clazz) {
		return update(_getSqlMapId(METHOD_DELETE, clazz), id);
	}

	public Long count(SearchObject o, Class<?> clazz) {
		return selectOne(_getSqlMapId(METHOD_COUNT, clazz), o);
	}
	
	public <T> T selectById(Object id, Class<?> clazz) {
		return (T) selectOne(
				_getSqlMapId(METHOD_SELECT_BY_ID, clazz), id);
	}
	
	public <E> Page<E> select(SearchObject o, Class<?> clazz) {
		return select(_getSqlMapId(METHOD_SELECT, clazz), o);
	}
	
	public <E> Page<E> select(String sqlMapId, SearchObject o) {
		PaginationResultHandler rh = new PaginationResultHandler();
		select(sqlMapId, o, rh);
		return Page.<E>make(rh);
	}
	
	public <E> List<E> selectList(SearchObject o, Class<?> clazz) {
		return selectList(_getSqlMapId(METHOD_SELECT, clazz), o);
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