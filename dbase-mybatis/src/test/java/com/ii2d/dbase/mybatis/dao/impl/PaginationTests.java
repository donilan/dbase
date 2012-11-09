//~ generate by eclipse
package com.ii2d.dbase.mybatis.dao.impl;

import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Doni
 * @since 2012-11-9
 * @version $id$
 * 
 */
public class PaginationTests{

	private ApplicationContext ac;
	private CommonMyBatisDAO dao;

	@Before
	public void setUp() throws SQLException {
		BasicConfigurator.configure();
		ac = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-mybatis-test.xml");
		dao = (CommonMyBatisDAO)ac.getBean("commonDao");
		
		
	}

	@Test
	public void testQuery2(){
		dao.sqlSession.selectList("list_User");
	}
	
	
}
