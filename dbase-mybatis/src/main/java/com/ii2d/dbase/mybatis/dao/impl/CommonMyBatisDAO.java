//~ generate by eclipse
package com.ii2d.dbase.mybatis.dao.impl;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.dao.support.PersistenceExceptionTranslator;

/**
 * common mybatis dao
 * @author Doni
 * @since 2012-9-9
 * @version $id$
 */
public class CommonMyBatisDAO extends AbstractMyBatisDAOImpl {

	public CommonMyBatisDAO(SqlSessionFactory sqlSessionFactory,
			ExecutorType executorType,
			PersistenceExceptionTranslator exceptionTranslator) {
		super(sqlSessionFactory, executorType, exceptionTranslator);
	}

	public CommonMyBatisDAO(SqlSessionFactory sqlSessionFactory,
			ExecutorType executorType) {
		super(sqlSessionFactory, executorType);
	}

	public CommonMyBatisDAO(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}

}
