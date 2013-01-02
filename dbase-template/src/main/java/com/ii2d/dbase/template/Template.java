//~ generate by eclipse
package com.ii2d.dbase.template;

import java.io.IOException;

import com.ii2d.dbase.template.context.Context;
import com.ii2d.dbase.template.node.NodeList;

/**
 * @author Doni
 * @since 2013-1-1
 * @version $id$
 * 
 */
public class Template {

	protected String _content;
	protected Context _context;
	protected NodeList _nodeList;

	public Template(String content, Context context) {
		this._content = content;
		this._context = context;
	}

	public NodeList parser() throws ParserException, IOException {
		if (_nodeList == null) {
			_nodeList = new Parser(Lexer.tokenize(_content)).parse(null);
		}
		return _nodeList;
	}

	public String render() throws ParserException, IOException {
		return parser().render(_context);
	}
}
