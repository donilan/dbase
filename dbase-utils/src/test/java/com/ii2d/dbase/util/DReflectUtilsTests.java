//~ generate by eclipse
package com.ii2d.dbase.util;

import java.sql.Types;
import java.util.List;

import junit.framework.TestCase;

/**
 * @author Doni
 * @since 2012-9-13
 * @version $id$
 * 
 */
public class DReflectUtilsTests extends TestCase {
	
	public void testGetFinalNames() {
		List<String> names = DReflectUtils.getFinalNames(Types.class, null);
		assertTrue(names.size() > 0);
	}
	
	public void testGetFieldValue() throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException {
		int val = DReflectUtils.getFinalFieldValue(Types.class, "BIT");
		assertTrue( val != 0);
	}

}
