//~ generate by eclipse
package com.ii2d.dbase.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Doni
 * @since 2012-9-13
 * @version $id$
 * 
 */
public class DDBUtils {
	
	private static final Log LOG = LogFactory.getLog(DDBUtils.class);
	
	public static final String KEY_DRIVER_CLASS = "DB_DRIVER_CLASS";
	public static final String KEY_USERNAME = "DB_USERNAME";
	public static final String KEY_PASSWORD = "DB_PASSWORD";
	public static final String KEY_URL = "DB_URL";
	
	public static final Map<Integer, String> TYPES = new HashMap<Integer, String>();
	public static final Map<String, String> DB_TYPE_MAP = new HashMap<String, String>();
	
	static {
		List<String> names = DReflectUtils.getFinalNames(Types.class);
		for(String n: names) {
			try {
				TYPES.put((Integer)DReflectUtils.getFinalFieldValue(Types.class, n), n);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		DB_TYPE_MAP.put("java.math.BigDecimal", "java.lang.Long");
		DB_TYPE_MAP.put("oracle.sql.TIMESTAMP", "java.util.Date");
		DB_TYPE_MAP.put("java.sql.Timestamp", "java.util.Date");
	}
	
	public static Connection getConnection(DataSource ds) throws SQLException {
		return getConnection(ds, null);
	}
	
	public static Connection getConnection(DataSource ds, String db) throws SQLException {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch(Exception e) {
			
			Map<String, String> env = System.getenv();
			
			String driverClass = System.getProperty(KEY_DRIVER_CLASS);
			if(StringUtils.isBlank(driverClass)) {
				driverClass = env.get(KEY_DRIVER_CLASS);
			}
			
			String url = System.getProperty(KEY_URL);
			if(StringUtils.isBlank(url)) {
				url = env.get(KEY_URL);
			}
			
			String username = System.getProperty(KEY_USERNAME);
			if(StringUtils.isBlank(username)) {
				username = env.get(KEY_USERNAME);
			}
			
			String password = System.getProperty(KEY_PASSWORD);
			if(StringUtils.isBlank(password)) {
				password = env.get(KEY_PASSWORD);
			}
			
			if(StringUtils.isBlank(url) || StringUtils.isBlank(driverClass)
					|| StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
				return null;
			}
			try {
				Class.forName(driverClass);
			} catch (ClassNotFoundException e1) {
				LOG.error("Driver class " + driverClass + " not found.");
			}
			conn = DriverManager.getConnection(
					StringUtils.isBlank(db)? url: String.format(url, db)
					, username, password);
		}
		return conn;
	}
	
	public static void getColumns(Connection conn, String table, Map<String, Object> resultMap) throws SQLException {
		if(conn == null) {
			LOG.error("Cannot get connection.");
			return;
		}
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s WHERE 1 = 2", table));
		ResultSetMetaData md = rs.getMetaData();
		List<Map<String, Object>> attrs = new ArrayList<Map<String, Object>>();
		for (int i = 1; i <= md.getColumnCount(); ++i) {
			Map<String, Object> attr = new HashMap<String, Object>();
			attr.put("name", md.getColumnName(i));
			attr.put("length", md.getPrecision(i));
			attr.put(
					"nullable",
					!(md.isNullable(i) == ResultSetMetaData.columnNoNulls));
			attr.put("className", md.getColumnClassName(i));
			attr.put("columnType", md.getColumnType(i));
			// add source property to source.
			attrs.add(attr);

			if (LOG.isDebugEnabled())
				LOG.debug(String
						.format("ColumnName [%s], ColumnClassName [%s]"
								+ ", CatalogName [%s], ColumnDisplaySize [%s]"
								+ ", ColumnLabel [%s], ColumnType [%s], ColumnTypeName [%s]"
								+ ", Precision [%d], Scale [%d]"
								+ ", SchemaName [%s], TableName [%s]",
								md.getColumnName(i),
								md.getColumnClassName(i),
								md.getCatalogName(i),
								md.getColumnDisplaySize(i),
								md.getColumnLabel(i),
								md.getColumnType(i),
								md.getColumnTypeName(i),
								md.getPrecision(i), md.getScale(i),
								md.getSchemaName(i),
								md.getTableName(i)));

		}
		resultMap.put("table", table);
		resultMap.put("attrs", attrs);
		if(conn != null) {
			conn.close();
		}
	}
	public static void getColumns(DataSource ds, String table, Map<String, Object> resultMap) throws SQLException {
		Connection conn = getConnection(ds);
		getColumns(conn, table, resultMap);
	}
}
