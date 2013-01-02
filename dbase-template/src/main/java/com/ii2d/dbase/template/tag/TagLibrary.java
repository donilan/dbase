//~ generate by eclipse
package com.ii2d.dbase.template.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.ii2d.dbase.template.Parser;
import com.ii2d.dbase.template.ParserException;
import com.ii2d.dbase.template.node.Node;
import com.ii2d.dbase.template.token.BlockToken;

/**
 * @author Doni
 * @since 2013-1-1
 * @version $id$
 * 
 */
public class TagLibrary {

	private static final Map<String, Tag> _tags = new HashMap<String, Tag>();

	static {
		register(new ExtendsTag());
		register(new BlockTag());
		register(new IncludeTag());
	}

	public static void register(Tag t) {
		_tags.put(t.getTagName(), t);
	}

	public static Node render(BlockToken token, Parser parser)
			throws ParserException, IOException {
		Tag t = _tags.get(token.getCommand());
		t.init(token, parser);
		return t.render();
	}
}
