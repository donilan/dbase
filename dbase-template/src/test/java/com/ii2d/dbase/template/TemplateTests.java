//~ generate by eclipse
package com.ii2d.dbase.template;

import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

import com.ii2d.dbase.template.context.Context;
import com.ii2d.dbase.template.finder.ClassTemplateFinder;
import com.ii2d.dbase.template.finder.TemplateFinder;

/**
 * @author Doni
 * @since 2013-1-2
 * @version $id$
 * 
 */
public class TemplateTests {

	@Test
	public void testRender() throws ParserException, IOException {
		TemplateFinder.register(new ClassTemplateFinder(TemplateTests.class));
		Template t = new Template(TestUtil.loadFile("grandpa.tmpl"), new Context());
		assertNotNull(t.render());
	}

}
