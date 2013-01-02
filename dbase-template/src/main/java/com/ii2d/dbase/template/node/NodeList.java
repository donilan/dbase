//~ generate by eclipse
package com.ii2d.dbase.template.node;

import java.io.IOException;
import java.util.ArrayList;

import com.ii2d.dbase.template.ParserException;
import com.ii2d.dbase.template.context.Context;

/**
 * @author Doni
 * @since 2013-1-1
 * @version $id$
 * 
 */
public class NodeList extends ArrayList<Node> {

	private static final long serialVersionUID = 1L;
	
	public String render(Context context) throws IOException, ParserException {
		StringBuffer sb = new StringBuffer(1024);
		for(Node n: this) {
			sb.append(n.render(context));
		}
		return sb.toString();
	}

	public NodeList getNodeListByClass(Class clazz) {
		NodeList nodeList = new NodeList();
		for(Node n: this) {
			if(n.getClass().equals(clazz))
				nodeList.add(n);
		}
		return nodeList;
	}
}
