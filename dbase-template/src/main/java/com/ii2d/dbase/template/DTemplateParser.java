//~ generate by eclipse
package com.ii2d.dbase.template;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ii2d.dbase.template.node.NodeList;
import com.ii2d.dbase.template.node.TextNode;
import com.ii2d.dbase.template.tag.TagLibrary;
import com.ii2d.dbase.template.token.BlockToken;
import com.ii2d.dbase.template.token.TextToken;
import com.ii2d.dbase.template.token.Token;

/**
 * @author Doni
 * @since 2013-1-1
 * @version $id$
 * 
 */
public class DTemplateParser {
	
	private List<Token> tokenList;

	public DTemplateParser(List<Token> tokenList) {
		this.tokenList = tokenList;
		if(this.tokenList == null) {
			this.tokenList = new ArrayList<Token>();
		}
	}
	
	public NodeList parse(String until) throws ParserException, IOException {
		NodeList nodeList = new NodeList();
		while(!tokenList.isEmpty()) {
			Token t = nextToken();
			if(t instanceof TextToken) {
				nodeList.add(new TextNode(t.getContent()));
			} else if (t instanceof BlockToken) {
				BlockToken token = (BlockToken)t;
				if(StringUtils.equals(until, token.getCommand()))
					break;
				nodeList.add(TagLibrary.render(token, this));
			}
			
		}
		return nodeList;
	}
	
	public Token nextToken() {
		return tokenList.remove(0);
	}
}
