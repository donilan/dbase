//~ generate by eclipse
package com.ii2d.dbase.template;

import java.io.IOException;
import java.util.List;

import com.ii2d.dbase.template.context.Context;
import com.ii2d.dbase.template.node.NodeList;
import com.ii2d.dbase.template.token.Token;

/**
 * @author Doni
 * @since 2013-1-1
 * @version $id$
 * 
 */
public class DTemplate {

	protected String _content;
	protected Context _context;
	protected NodeList _nodeList;

	public DTemplate(String content, Context context) {
		this._content = content;
		this._context = context;
	}

	public NodeList parser() throws ParserException, IOException {
		if (_nodeList == null) {
			List<Token> tokens = DTemplateLexer.tokenize(_content);
			DTemplateParser parser = new DTemplateParser(tokens);
			_nodeList = parser.parse(null);
		}
		return _nodeList;
	}

	public String render() throws ParserException, IOException {
		return parser().render(_context);
	}
}
