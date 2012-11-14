//~ generate by eclipse
package com.ii2d.dbase.commons.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.ii2d.dbase.mybatis.Page;
import com.ii2d.dbase.mybatis.SearchObject;

/**
 * @author Doni
 * @since 2012-11-12
 * @version $id$
 * 
 */
public interface CommonService {

	public abstract int insert(Object o);

	public abstract int insert(Collection<?> objs);

	public abstract int update(Object o);

	public abstract int delete(Object id, Class<?> clazz);

	public abstract <T> T selectById(Object id, Class<?> clazz);

	public abstract <E> Page<E> select(SearchObject o, Class<?> clazz);

	public abstract <E> Page<E> select(String sqlMapId, SearchObject o);

	public abstract <T> T selectOne(String statement);

	public abstract <T> T selectOne(String statement, Object parameter);

	public abstract <K, V> Map<K, V> selectMap(String statement, String mapKey);

	public abstract <K, V> Map<K, V> selectMap(String statement,
			Object parameter, String mapKey);

	public abstract <K, V> Map<K, V> selectMap(String statement,
			Object parameter, String mapKey, RowBounds rowBounds);

	public abstract <E> List<E> selectList(String statement);

	public abstract <E> List<E> selectList(String statement, Object parameter);

	public abstract <E> List<E> selectList(String statement, Object parameter,
			RowBounds rowBounds);

	public abstract void select(String statement, ResultHandler handler);

	public abstract void select(String statement, Object parameter,
			ResultHandler handler);

	public abstract void select(String statement, Object parameter,
			RowBounds rowBounds, ResultHandler handler);

	public abstract int insert(String statement);

	public abstract int insert(String statement, Object parameter);

	public abstract int update(String statement);

	public abstract int update(String statement, Object parameter);

	public abstract int delete(String statement);

	public abstract int delete(String statement, Object parameter);

}