package com.ii2d.dbase.mybatis.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ii2d.dbase.mybatis.Page;
import com.ii2d.dbase.mybatis.SearchObject;

/**
 * Base mybatis dao
 * @author Doni
 * @since 2012-09-09
 * @version $id$
 */
public interface BaseMyBatisDAO extends SqlSession {

	int insert(Object o);

	int insert(Collection<?> objs);

	int update(Object o);

	int delete(Object id, Class<?> clazz);

	Long count(SearchObject o, Class<?> clazz);

	<T> T selectById(Object id, Class<?> clazz);

	<E> Page<E> select(SearchObject o, Class<?> clazz);

	<E> Page<E> select(String sqlMapId, SearchObject o);
	
	<E> List<E> selectList(SearchObject o, Class<?> clazz);
	
}