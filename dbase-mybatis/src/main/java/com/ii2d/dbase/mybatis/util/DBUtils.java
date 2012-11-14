//~ generate by eclipse
package com.ii2d.dbase.mybatis.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.builder.xml.dynamic.ForEachSqlNode;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

/**
 * @author Doni
 * @since 2012-11-9
 * @version $id$
 * 
 */
public class DBUtils {

	private static final Log LOG = LogFactory.getLog(DBUtils.class);

	public static void setParameters(PreparedStatement ps,
			MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ErrorContext.instance().activity("setting parameters")
				.object(mappedStatement.getParameterMap().getId());
		List<ParameterMapping> parameterMappings = boundSql
				.getParameterMappings();
		if (parameterMappings != null) {
			Configuration configuration = mappedStatement.getConfiguration();
			TypeHandlerRegistry typeHandlerRegistry = configuration
					.getTypeHandlerRegistry();
			for (int i = 0; i < parameterMappings.size(); i++) {
				ParameterMapping parameterMapping = parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT) {
					Object value = null;
					String propertyName = parameterMapping.getProperty();
					PropertyTokenizer prop = new PropertyTokenizer(propertyName);
					if (parameterObject == null) {
						value = null;
					} else if (typeHandlerRegistry
							.hasTypeHandler(parameterObject.getClass())) {
						value = parameterObject;
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						value = boundSql.getAdditionalParameter(propertyName);
					} else if (propertyName
							.startsWith(ForEachSqlNode.ITEM_PREFIX)
							&& boundSql.hasAdditionalParameter(prop.getName())) {
						value = boundSql.getAdditionalParameter(prop.getName());
						if (value != null) {
							value = configuration.newMetaObject(value)
									.getValue(
											propertyName.substring(prop
													.getName().length()));
						}
					} else {
						if (parameterObject != null) {
							MetaObject metaObject = configuration
									.newMetaObject(parameterObject);
							value = metaObject == null ? null : metaObject
									.getValue(propertyName);
						}
					}
					TypeHandler typeHandler = parameterMapping.getTypeHandler();
					if (typeHandler == null) {
						throw new ExecutorException(
								"There was no TypeHandler found for parameter "
										+ propertyName + " of statement "
										+ mappedStatement.getId());
					}
					typeHandler.setParameter(ps, i + 1, value,
							parameterMapping.getJdbcType());
				}
			}
		}
	}

	public static Connection getConn(MappedStatement ms) throws SQLException {
		return ms.getConfiguration().getEnvironment().getDataSource()
				.getConnection();
	}

	public static Long getCount(final MappedStatement ms,
			final Object parameterObject)
			throws SQLException {
		BoundSql boundSql = ms.getBoundSql(parameterObject);
		String countSql = new StringBuffer(256)
				.append("SELECT COUNT(1) FROM (")
				.append(boundSql.getSql())
				.append(") TMP_COUNT").toString();
		
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection connection = getConn(ms);
		try {
			countSql = countSql.replaceAll("\\s+", " ");
			if (LOG.isDebugEnabled()) {
				LOG.debug("Executing sql: " + countSql);
			}
			st = connection.prepareStatement(countSql);
			BoundSql countBS = new BoundSql(ms.getConfiguration(), countSql,
					boundSql.getParameterMappings(), parameterObject);
			setParameters(st, ms, countBS, parameterObject);

			rs = st.executeQuery();
			if (rs.next()) {
				if (LOG.isDebugEnabled())
					LOG.debug("Counting result is: " + rs.getLong(1));
				return rs.getLong(1);
			}
			return 0L;
		} finally {
			close(rs, st, connection);
		}
	}

	public static void close(ResultSet rs, PreparedStatement st, Connection conn)
			throws SQLException {
		close(rs);
		close(st);
		close(conn);
	}

	public static void close(PreparedStatement st) throws SQLException {
		if (st != null) {
			st.close();
		}
	}

	public static void close(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}
	
	public static void close(Connection conn) throws SQLException {
		if( conn != null) {
			conn.close();
		}
	}
}
