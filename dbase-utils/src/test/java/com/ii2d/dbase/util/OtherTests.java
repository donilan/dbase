//~ generate by eclipse
package com.ii2d.dbase.util;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import junit.framework.TestCase;

/**
 * @author Doni
 * @since 2012-9-22
 * @version $id$
 * 
 */
public class OtherTests extends TestCase {

	public void testGetResource() {
		try {
			Enumeration<URL> urls = this.getClass().getClassLoader().getSystemResources("org");
			while(urls.hasMoreElements()) {
				URL url = urls.nextElement();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
