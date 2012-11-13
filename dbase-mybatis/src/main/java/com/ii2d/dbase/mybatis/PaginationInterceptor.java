//~ generate by eclipse
package com.ii2d.dbase.mybatis;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.ii2d.dbase.mybatis.dialect.Dialect;
import com.ii2d.dbase.mybatis.dialect.db.NullDialect;
import com.ii2d.dbase.mybatis.util.DBUtils;
import com.ii2d.dbase.mybatis.util.MappedStatementUtils;

/**
 * @author Doni
 * @since 2012-11-9
 * @version $id$
 * 
 */
@Intercepts({ @Signature(type = Executor.class, method = "query", args = {
		MappedStatement.class, Object.class, RowBounds.class,
		ResultHandler.class }) })
public class PaginationInterceptor implements Interceptor {

	private final static Log LOG = LogFactory
			.getLog(PaginationInterceptor.class);

	protected Dialect _dialect = new NullDialect();

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement ms 		= (MappedStatement) invocation.getArgs()[0];
		SearchObject searchObject	= _toSearchObject(invocation.getArgs()[1]);
		PaginationResultHandler rh = toPaginationResultHandler(invocation.getArgs()[3]);
		
		if (searchObject != null && rh != null) {
			BoundSql boundSql = ms.getBoundSql(searchObject);
			BoundSql newBoundSql = MappedStatementUtils.newBoundSql(ms,
					_dialect.getLimitString(boundSql.getSql(), searchObject),
					boundSql);
			invocation.getArgs()[0] = MappedStatementUtils
					.copyFromMappedStatement(ms, newBoundSql);
			Long _count = DBUtils.getCount(ms, searchObject);
			rh.setCount(_count);
			rh.setSearchObject(searchObject);
		}
		return invocation.proceed();
	}
	
	protected SearchObject _toSearchObject(Object o) {
		if(o instanceof SearchObject)
			return (SearchObject)o;
		return null;
	}
	
	protected PaginationResultHandler toPaginationResultHandler(Object o) {
		if(o instanceof PaginationResultHandler) 
			return (PaginationResultHandler)o;
		return null;
	}
	
	protected boolean isHandleThisOne(BoundSql boundSql, RowBounds rowBounds) {
		String _sql = StringUtils.trim(boundSql.getSql());
		return rowBounds != null && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT
				&& StringUtils.startsWith(StringUtils.upperCase(_sql), "SELECT");
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties _p) {

		String _dc = _p.getProperty("dialectClass");
		if (StringUtils.isNotBlank(_dc)) {
			try {
				Class<?> _class = Class.forName(_dc);
				_dialect = (Dialect) _class.newInstance();
			} catch (Exception e) {
				LOG.error(e);
			}
		}
		LOG.info("Using dialect class: "
				+ _dialect.getClass().getCanonicalName());
	}

	public static class BoundSqlSqlSource implements SqlSource {
		BoundSql boundSql;

		public BoundSqlSqlSource(BoundSql boundSql) {
			this.boundSql = boundSql;
		}

		public BoundSql getBoundSql(Object parameterObject) {
			return boundSql;
		}
	}
}
