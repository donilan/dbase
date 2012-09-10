//~ generate by eclipse
package com.ii2d.dbase.util;

import java.io.IOException;

import junit.framework.TestCase;

/**
 * @author Doni
 * @since 2012-9-10
 * @version $id$
 * 
 */
public class DResourceUtilsTests extends TestCase {

	public void testGetResourceAsFile() throws IOException {
		DResourceUtils.getResourceAsFile("stylesheet.css");
	}
}
