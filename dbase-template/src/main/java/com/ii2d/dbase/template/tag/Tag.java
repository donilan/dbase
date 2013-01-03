//~ generate by eclipse
package com.ii2d.dbase.template.tag;

import java.io.IOException;

import com.ii2d.dbase.template.DTemplateParser;
import com.ii2d.dbase.template.ParserException;
import com.ii2d.dbase.template.node.Node;
import com.ii2d.dbase.template.token.BlockToken;

/**
 * @author Doni
 * @since 2013-1-1
 * @version $id$
 * 
 */
public abstract class Tag {

	protected BlockToken blockToken;
	protected DTemplateParser parser;

	public void init(BlockToken blockToken, DTemplateParser parser) {
		this.blockToken = blockToken;
		this.parser = parser;
	}

	protected void mustAtLineNo(int lineNo) throws ParserException {
		if (blockToken.getLineNo() != lineNo) {
			throw new ParserException(String.format(
					"Tag [%s] must at line %d.", this.getTagName(), lineNo));
		}
	}

	protected void argsLength(int length) throws ParserException {
		if (blockToken.getArgs().size() != length) {
			throw new ParserException(String.format(
					"Tag [%s] arg length must be %d.", this.getTagName(),
					length));
		}
	}

	public abstract String getTagName();

	public abstract Node render() throws ParserException, IOException;
}
