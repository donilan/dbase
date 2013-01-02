//~ generate by eclipse
package com.ii2d.dbase.template.finder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ii2d.dbase.template.ParserException;
import com.ii2d.dbase.template.Template;
import com.ii2d.dbase.template.context.Context;

/**
 * @author Doni
 * @since 2013-1-2
 * @version $id$
 * 
 */
public abstract class TemplateFinder {

	private static final List<TemplateFinder> finders = new ArrayList<TemplateFinder>();

	protected abstract String getTemplateString(String tmplName)
			throws IOException;

	public static Template getTemplate(String tmplName, Context context)
			throws IOException, ParserException {
		if (context == null) {
			context = new Context();
		}
		Template t = new Template(findTemplateString(tmplName), context);
		return t;
	}

	protected static String findTemplateString(String tmplName)
			throws IOException, ParserException {
		if (finders == null || finders.size() < 1) {
			throw new ParserException("Please register a emplate finder.");
		}
		for (TemplateFinder tf : finders) {
			try {
				String tmplStr = tf.getTemplateString(tmplName);
				return tmplStr;
			} catch (IOException e) {
				// NOT FOUND, IGNORE.
			}
		}
		throw new IOException("Template not found.");
	}
	
	public static void register(TemplateFinder finder) {
		finders.add(finder);
	}
}
