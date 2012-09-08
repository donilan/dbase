//~ generate by eclipse
package org.dbase.mybatis.dao.impl;

import junit.framework.TestCase;

/**
 * @author Doni
 * @since 2012-9-9
 * @version $id$
 * 
 */
public class CommonMyBatisDAOTests extends TestCase {

	public void test_getSqlMapId() {
		CommonMyBatisDAO dao = new CommonMyBatisDAO();
		assertEquals("select_String", dao._getSqlMapId(CommonMyBatisDAO.METHOD_SELECT, String.class));
	}
}
