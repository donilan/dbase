//~ generate by eclipse
package com.ii2d.dbase.util;

import junit.framework.TestCase;

/**
 * @author Doni
 * @since 2012-9-12
 * @version $id$
 * 
 */
public class DNameUtilsTests extends TestCase {

	public void testToKeyName() {
		assertEquals("__KEY_NAME__", DNameUtils.toKeyName("keyName"));
		assertEquals("__KEY__NAME__", DNameUtils.toKeyName("key_Name"));
	}
	
	public void testToCamelName() {
		assertEquals("camelName", DNameUtils.toCamelName("camel_name"));
		assertEquals("camelName", DNameUtils.toCamelName("camel__name"));
	}
	
	public void testToPascalName() {
		assertEquals("PascalName", DNameUtils.toPascalName("pascal_name"));
	}
}
