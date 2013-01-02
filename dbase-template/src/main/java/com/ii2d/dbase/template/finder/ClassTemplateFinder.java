//~ generate by eclipse
package com.ii2d.dbase.template.finder;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

/**
 * @author Doni
 * @since 2013-1-2
 * @version $id$
 * 
 */
public class ClassTemplateFinder extends TemplateFinder {
	
	private Class<?> clazz;
	public ClassTemplateFinder(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	protected String getTemplateString(String tmplName) throws IOException {
		return IOUtils.toString(clazz.getResourceAsStream(tmplName));
	}

}
