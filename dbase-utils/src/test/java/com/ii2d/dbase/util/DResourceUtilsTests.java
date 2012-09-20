//~ generate by eclipse
package com.ii2d.dbase.util;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

/**
 * @author Doni
 * @since 2012-9-10
 * @version $id$
 * 
 */
public class DResourceUtilsTests extends TestCase {

	public void testGetResourceAsFile() throws IOException {
		DResourceUtils.getResourceAsFile("classpath:stylesheet.css");
	}
	
	public void testGetResourceAsStream() throws IOException{
		InputStream in = DResourceUtils.getResourceAsStream("classpath:  stylesheet.css");
		assertTrue(in.available() > 0);
	}
	
	public void testGetResourceAsReader() throws IOException {
		DResourceUtils.getResourceAsReader("   classpath:   stylesheet.css    ");
	}
	
	public void testGetResourceAsArchiveInputStream() throws IOException{
		DResourceUtils.getResourceAsArchiveInputStream("classpath:com/ii2d/genthemall/template/commons/model/__PATH__/model/__PASCAL_NAME__.java");
		
	}
	
}
