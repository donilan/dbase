//~ generate by eclipse
package com.ii2d.dbase.mybatis.service;

import com.ii2d.dbase.mybatis.dao.impl.CommonMyBatisDAO;
import com.ii2d.dbase.mybatis.model.User;

/**
 * @author Doni
 * @since 2012-9-12
 * @version $id$
 * 
 */
public class CommonService {
	private CommonMyBatisDAO dao;

	public CommonMyBatisDAO getDao() {
		return dao;
	}

	public void setDao(CommonMyBatisDAO dao) {
		this.dao = dao;
	}
	
	public void insertTwoUser() throws Exception {
		User u1 = new User();
		u1.setUsername("u1");
		u1.setPassword("1");
		dao.insert(u1);
		throw new Exception();
	}
}
