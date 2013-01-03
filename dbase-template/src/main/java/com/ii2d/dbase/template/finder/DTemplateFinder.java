//~ generate by eclipse
package com.ii2d.dbase.template.finder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ii2d.dbase.template.ParserException;
import com.ii2d.dbase.template.DTemplate;
import com.ii2d.dbase.template.context.Context;

/**
 * @author Doni
 * @since 2013-1-2
 * @version $id$
 * 
 */
public abstract class DTemplateFinder implements ITemplateFinder {

	private static final List<ITemplateFinder> finders = new ArrayList<ITemplateFinder>();

	public static DTemplate getTemplate(String tmplName, Context context)
			throws IOException, ParserException {
		if (context == null) {
			context = new Context();
		}
		DTemplate t = new DTemplate(findTemplateString(tmplName), context);
		return t;
	}

	protected static String findTemplateString(String tmplName)
			throws IOException, ParserException {
		if (finders == null || finders.size() < 1) {
			throw new ParserException("Please register a template finder.");
		}
		for (ITemplateFinder tf : finders) {
			try {
				String tmplStr = tf.getTemplateString(tmplName);
				return tmplStr;
			} catch (IOException e) {
				// NOT FOUND, IGNORE.
			}
		}
		throw new IOException("Template not found.");
	}
	
	public static void register(ITemplateFinder finder) {
		finders.add(finder);
	}
	public static void unregister(ITemplateFinder finder) {
		finders.remove(finder);
	}
}
