//~ generate by eclipse
package com.ii2d.dbase.util;

import java.sql.Connection;
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
	
	public static final Map<Integer, String> TYPES = new HashMap<Integer, String>();
	
	static {
		List<String> names = DReflectUtils.getFinalNames(Types.class);
		for(String n: names) {
			try {
				TYPES.put((Integer)DReflectUtils.getFinalFieldValue(Types.class, n), n);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void getColumns(DataSource ds, String table, Map<String, Object> resultMap) throws SQLException {
		Connection conn = ds.getConnection();
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
}
