//~ generate by eclipse
package com.ii2d.dbase.template;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @author Doni
 * @since 2013-1-1
 * @version $id$
 * 
 */
public class LexerTests {

	@Test
	public void testParser() throws ParserException {
		assertTrue(DTemplateLexer.tokenize(TestUtil.loadFile("child.tmpl")).size() > 0);
	}

}
