//~ generate by eclipse
package com.ii2d.dbase.template.node;

import com.ii2d.dbase.template.context.Context;

/**
 * @author Doni
 * @since 2013-1-2
 * @version $id$
 * 
 */
public class TextNode extends Node {
	private String content;
	public TextNode(String content) {
		this.content = content;
	}

	@Override
	public String render(Context context) {
		return this.content;
	}

}
