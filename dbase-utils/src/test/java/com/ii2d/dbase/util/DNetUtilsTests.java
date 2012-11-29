//~ generate by eclipse
package com.ii2d.dbase.util;

import java.io.IOException;

import org.junit.Test;
import org.junit.Assert;

/**
 * @author Doni
 * @since 2012-11-29
 * @version $id$
 * 
 */
public class DNetUtilsTests {
	
	@Test
	public void testPing() throws IOException {
		Assert.assertTrue(DNetUtils.ping("127.0.0.1"));
	}
}
