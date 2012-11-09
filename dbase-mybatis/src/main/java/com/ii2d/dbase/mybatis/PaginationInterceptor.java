//~ generate by eclipse
package com.ii2d.dbase.mybatis;

import java.util.Collection;
import java.util.Properties;
import java.util.regex.Pattern;

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

	protected Pattern _sqlMapPattern = Pattern.compile(".*select.*");
	protected Dialect _dialect = new NullDialect();

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
		RowBounds rowBounds = (RowBounds) invocation.getArgs()[2];
		if (rowBounds != null && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT
				&& _sqlMapPattern.matcher(ms.getId()).matches()) {
			Object parameterObject = invocation.getArgs()[1];
			BoundSql boundSql = ms.getBoundSql(parameterObject);
			BoundSql newBoundSql = MappedStatementUtils.newBoundSql(ms,
					_dialect.getLimitString(boundSql.getSql(), rowBounds),
					boundSql);
			invocation.getArgs()[0] = MappedStatementUtils
					.copyFromMappedStatement(ms, newBoundSql);
			Object result = invocation.proceed();
			if (result instanceof Collection) {
				Page page = Page.make((Collection) result, rowBounds, DBUtils.getCount(ms, parameterObject));
				return page;
			}
			return result;
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties _p) {

		String _pattern = _p.getProperty("pattern");
		if (StringUtils.isNotBlank(_pattern)) {
			this._sqlMapPattern = Pattern.compile(_pattern);
		}
		LOG.info("Using pattern " + _sqlMapPattern.pattern());
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
