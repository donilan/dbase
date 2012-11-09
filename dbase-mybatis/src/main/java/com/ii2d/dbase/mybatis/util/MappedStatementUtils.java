//~ generate by eclipse
package com.ii2d.dbase.mybatis.util;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @author Doni
 * @since 2012-11-9
 * @version $id$
 * 
 */
public class MappedStatementUtils {
	
	public static BoundSql newBoundSql(MappedStatement ms, String newSql, BoundSql oldBoundSql) {
		return new BoundSql(ms.getConfiguration(),
				newSql, oldBoundSql.getParameterMappings(),
				oldBoundSql.getParameterObject());
	}

	public static MappedStatement copyFromMappedStatement(MappedStatement ms,
			BoundSql boundSql) {
		MappedStatement.Builder builder = new MappedStatement.Builder(
				ms.getConfiguration(), ms.getId(), makeSqlSource(boundSql),
				ms.getSqlCommandType());
		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		if (ms.getKeyProperties() != null) {
			for (String keyProperty : ms.getKeyProperties()) {
				builder.keyProperty(keyProperty);
			}
		}
		builder.timeout(ms.getTimeout());
		builder.parameterMap(ms.getParameterMap());
		builder.resultMaps(ms.getResultMaps());
		builder.cache(ms.getCache());
		return builder.build();
	}
	
	public static SqlSource makeSqlSource(BoundSql s) {
		return new BoundSqlSource(s);
	}
	
	private static class BoundSqlSource implements SqlSource {
		
		private BoundSql boundSql;

		public BoundSqlSource(BoundSql s) {
			this.boundSql = s;
		}
		@Override
		public BoundSql getBoundSql(Object parameterObject) {
			return boundSql;
		}
		
	}
}
