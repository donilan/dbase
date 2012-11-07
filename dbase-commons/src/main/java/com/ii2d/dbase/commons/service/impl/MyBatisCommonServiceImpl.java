//~ generate by eclipse
package com.ii2d.dbase.commons.service.impl;

import java.util.Collection;
import java.util.List;

import com.ii2d.dbase.commons.service.CommonService;
import com.ii2d.dbase.mybatis.Page;
import com.ii2d.dbase.mybatis.dao.impl.CommonMyBatisDAO;
import com.ii2d.dbase.mybatis.model.BaseMyBatisModel;

/**
 * @author Doni
 * @since 2012-9-17
 * @version $id$
 * 
 */
public class MyBatisCommonServiceImpl implements CommonService {
	
	private CommonMyBatisDAO commonMyBatiesDAO;

	public int insert(BaseMyBatisModel o) {
		return commonMyBatiesDAO.insert(o);
	}

	public int update(BaseMyBatisModel o) {
		return commonMyBatiesDAO.update(o);
	}

	@SuppressWarnings("rawtypes")
	public int delete(Object id, Class clazz) {
		return commonMyBatiesDAO.delete(id, clazz);
	}

	public <T> List<T> queryForList(BaseMyBatisModel o) {
		return commonMyBatiesDAO.queryForList(o);
	}

	public Page queryForPage(BaseMyBatisModel o, int page, int rows) {
		return commonMyBatiesDAO.queryForPage(o, page, rows);
	}

	public <T> T queryForById(Object id, Class<?> clazz) {
		return commonMyBatiesDAO.queryForById(id, clazz);
	}

	public Long count(BaseMyBatisModel o) {
		return commonMyBatiesDAO.count(o);
	}
	
	public <T> T queryOne(String sqlMapId, Object searchObj) {
		return commonMyBatiesDAO.queryOne(sqlMapId, searchObj);
	}

	public <T> List<T> queryForList(String sqlMapId, Object o) {
		return commonMyBatiesDAO.queryForList(sqlMapId, o);
	}

	public <T> List<T> queryForList(String sqlMapId, Object o, int page,
			int rows) {
		return commonMyBatiesDAO.queryForList(sqlMapId, o, page, rows);
	}

	public CommonMyBatisDAO getCommonMyBatiesDAO() {
		return commonMyBatiesDAO;
	}

	public void setCommonMyBatiesDAO(CommonMyBatisDAO commonMyBatiesDAO) {
		this.commonMyBatiesDAO = commonMyBatiesDAO;
	}

	public int insert(String sqlMapId, Object insertObj) {
		return commonMyBatiesDAO.insert(sqlMapId, insertObj);
	}

	public int update(String sqlMapId, Object updateObj) {
		return commonMyBatiesDAO.update(sqlMapId, updateObj);
	}

	public Long query2Long(String sqlMapId, Object searchObj) {
		return commonMyBatiesDAO.query2Long(sqlMapId, searchObj);
	}

	@Override
	public int insert(Collection<? extends BaseMyBatisModel> objects) {
		for(BaseMyBatisModel o: objects)
			commonMyBatiesDAO.insert(o);
		return objects.size();
	}
	
}
