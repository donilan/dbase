//~ generate by eclipse
package com.ii2d.dbase.commons.service.impl;

import java.util.List;

import com.ii2d.dbase.commons.model.Menu;
import com.ii2d.dbase.commons.service.MenuService;
import com.ii2d.dbase.mybatis.SearchObject;

/**
 * @author Doni
 * @since 2012-12-4
 * @version $id$
 * 
 */
public class MenuServiceImpl extends MyBatisCommonServiceImpl implements MenuService {
	
	@Override
	public List<?> getMenusByGroup(String group) {
		SearchObject so = new SearchObject();
		so.andEq("menuGroup", group);
		return commonMyBatiesDAO.selectList(so, Menu.class);
	}
	
}
