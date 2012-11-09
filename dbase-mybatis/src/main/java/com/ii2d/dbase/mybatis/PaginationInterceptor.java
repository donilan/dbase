//~ generate by eclipse
package com.ii2d.dbase.mybatis;

import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

import com.ii2d.dbase.mybatis.dialect.Dialect;
import com.ii2d.dbase.mybatis.dialect.db.NullDialect;



/**
 * @author Doni
 * @since 2012-11-9
 * @version $id$
 * 
 */
public class PaginationInterceptor implements Interceptor {

	private final static Log LOG = LogFactory.getLog(PaginationInterceptor.class);
	
	protected Pattern _sqlMapPattern = Pattern.compile("list.*");
	protected Dialect _dialect = new NullDialect();
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("=============="+invocation);
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		System.out.println(_dialect.getClass());
		System.out.println(target);
		System.out.println("==========2");
		return target;
	}

	@Override
	public void setProperties(Properties _p) {
		
		String _pattern = _p.getProperty("pattern");
		if(StringUtils.isNotBlank(_pattern)) {
			this._sqlMapPattern = Pattern.compile(_pattern);
		}
		LOG.info("Using pattern " + _sqlMapPattern.pattern());
		String _dc = _p.getProperty("dialectClass");
		if(StringUtils.isNotBlank(_dc)) {
			try {
				Class<?> _class = Class.forName(_dc); 
				_dialect = (Dialect)_class.newInstance();
			} catch (Exception e) {
				LOG.error(e);
			}
		}
		LOG.info("Using dialect class: " + _dialect.getClass().getCanonicalName());
	}

}
