//~ generate by eclipse
package com.ii2d.dbase.template;

import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

import com.ii2d.dbase.template.context.Context;
import com.ii2d.dbase.template.finder.ClassTemplateFinder;
import com.ii2d.dbase.template.finder.DTemplateFinder;

/**
 * @author Doni
 * @since 2013-1-2
 * @version $id$
 * 
 */
public class TemplateTests {

	@Test
	public void testRender() throws ParserException, IOException {
		DTemplateFinder.register(new ClassTemplateFinder(TemplateTests.class));
		DTemplate t = new DTemplate(TestUtil.loadFile("grandpa.tmpl"), new Context());
		System.out.print(t.render());
		assertNotNull(t.render());
	}

}
