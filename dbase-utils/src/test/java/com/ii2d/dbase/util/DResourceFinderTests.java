//~ generate by eclipse
package com.ii2d.dbase.util;

import java.io.IOException;

import junit.framework.TestCase;

/**
 * @author Doni
 * @since 2012-9-22
 * @version $id$
 * 
 */
public class DResourceFinderTests extends TestCase {

	public void testFind() throws IOException {
		assertTrue(DResourceFinder.find("classpath:junit",
				new String[] { "Logo.class" }, null).size() > 0);
	}
}
