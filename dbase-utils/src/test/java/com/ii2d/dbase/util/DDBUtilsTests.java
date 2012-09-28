//~ generate by eclipse
package com.ii2d.dbase.util;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author Doni
 * @since 2012-9-26
 * @version $id$
 * 
 */
public class DDBUtilsTests extends TestCase {

	public void testGetColumns() throws SQLException {
		BasicDataSource ds = new BasicDataSource();
		ds.setUsername("root");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/hnwnew");
		Map<String, Object> map = new HashMap<String, Object>();
		DDBUtils.getColumns(ds, "user", map);
		System.out.println(map);
	}
}
