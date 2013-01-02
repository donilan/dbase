//~ generate by eclipse
package com.ii2d.dbase.template.node;

import java.io.IOException;

import com.ii2d.dbase.template.ParserException;
import com.ii2d.dbase.template.context.Context;

/**
 * @author Doni
 * @since 2013-1-1
 * @version $id$
 * 
 */
public abstract class Node {
	public abstract String render(Context context) throws IOException, ParserException;
}
