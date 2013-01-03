//~ generate by eclipse
package com.ii2d.dbase.template.finder;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @author Doni
 * @since 2013-1-2
 * @version $id$
 * 
 */
public class FileTemplateFinder extends DTemplateFinder {

	@Override
	public String getTemplateString(String path) throws IOException {
		return FileUtils.readFileToString(new File(path));
	}

}
