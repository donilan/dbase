//~ generate by eclipse
package com.ii2d.dbase.template.tag;

import java.io.IOException;

import com.ii2d.dbase.template.ParserException;
import com.ii2d.dbase.template.context.Context;
import com.ii2d.dbase.template.finder.TemplateFinder;
import com.ii2d.dbase.template.node.Node;

/**
 * @author Doni
 * @since 2013-1-2
 * @version $id$
 * 
 */
public class IncludeTag extends Tag {

	@Override
	public String getTagName() {
		return "include";
	}

	@Override
	public Node render() throws ParserException, IOException {
		argsLength(1);
		final Tag that = this;
		return new Node() {
			@Override
			public String render(Context context) throws IOException, ParserException {
				return TemplateFinder.getTemplate(
						that.blockToken.getArgs().get(0), null).render();
			}
		};
	}

}
