//~ generate by eclipse
package com.ii2d.dbase.template;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

/**
 * @author Doni
 * @since 2013-1-1
 * @version $id$
 * 
 */
public class TestUtil {
	public static String loadFile(String name) {
		try {
			return IOUtils.toString(TestUtil.class.getResourceAsStream(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
