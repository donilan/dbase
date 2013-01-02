//~ generate by eclipse
package com.ii2d.dbase.template.tag;

import java.io.IOException;
import java.util.List;

import com.ii2d.dbase.template.ParserException;
import com.ii2d.dbase.template.node.ExtendsNode;
import com.ii2d.dbase.template.node.Node;

/**
 * @author Doni
 * @since 2013-1-2
 * @version $id$
 * 
 */
public class ExtendsTag extends Tag {

	@Override
	public String getTagName() {
		return "extends";
	}

	@Override
	public Node render() throws ParserException, IOException {
		this.mustAtLineNo(0);
		this.argsLength(1);
		List<String> args = this.blockToken.getArgs();
		return new ExtendsNode(this.parser.parse(null), args.get(0));
	}

}
