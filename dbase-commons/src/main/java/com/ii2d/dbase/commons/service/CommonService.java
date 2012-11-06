//~ generate by eclipse
package com.ii2d.dbase.commons.service;

import java.util.List;

import com.ii2d.dbase.mybatis.Page;
import com.ii2d.dbase.mybatis.model.BaseMyBatisModel;

/**
 * @author Doni
 * @since 2012-9-17
 * @version $id$
 * 
 */
public interface CommonService {

	int insert(BaseMyBatisModel o);

	int update(BaseMyBatisModel o);

	@SuppressWarnings("rawtypes")
	int delete(Object id, Class clazz);

	<T> List<T> queryForList(BaseMyBatisModel o);

	Page queryForPage(BaseMyBatisModel o, int page, int rows);

	<T> T queryForById(Object id, Class<?> clazz);

	Long count(BaseMyBatisModel o);

	<T> T queryOne(String sqlMapId, Object searchObj);
	
	<T> List<T> queryForList(String sqlMapId, Object o);

	<T> List<T> queryForList(String sqlMapId, Object o, int page, int rows);

}
