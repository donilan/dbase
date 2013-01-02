//~ generate by eclipse
package com.ii2d.dbase.template.tag;

import java.io.IOException;

import com.ii2d.dbase.template.ParserException;
import com.ii2d.dbase.template.node.BlockNode;
import com.ii2d.dbase.template.node.Node;
import com.ii2d.dbase.template.node.NodeList;

/**
 * @author Doni
 * @since 2013-1-2
 * @version $id$
 * 
 */
public class BlockTag extends Tag {

	@Override
	public String getTagName() {
		return "block";
	}

	@Override
	public Node render() throws ParserException, IOException {
		argsLength(1);
		NodeList nodeList = this.parser.parse("endblock");
//		this.parser.nextToken();
		return new BlockNode(this.blockToken.getArgs().get(0), nodeList);
	}

}
