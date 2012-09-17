//~ generate by eclipse
package com.ii2d.dbase.mybatis.dao.impl;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ii2d.dbase.mybatis.model.User;
import com.ii2d.dbase.mybatis.service.CommonService;

/**
 * @author Doni
 * @since 2012-9-9
 * @version $id$
 * 
 */
public class CommonMyBatisDAOTests extends TestCase {
	
	private ApplicationContext ac;
	
	public void setUp() {
		ac = new ClassPathXmlApplicationContext("classpath:applicationContext-mybatis-test.xml");
	}

	public void test_getSqlMapId() {
		CommonMyBatisDAO dao = new CommonMyBatisDAO();
		assertEquals("select_String", dao._getSqlMapId(CommonMyBatisDAO.METHOD_SELECT, "".getClass()));
	}
	
	public void testQuery() {
		
		CommonMyBatisDAO dao = (CommonMyBatisDAO)ac.getBean("commonDao");
		User u = new User();
		u.setUsername("username");
		u.setPassword("123456");
		dao.insert(u);
	}
	
	public void testTransaction() {
		CommonService service = (CommonService)ac.getBean("commonServic");
		try {
			service.insertTwoUser();
		} catch (Exception e) {
		}
	}
}
