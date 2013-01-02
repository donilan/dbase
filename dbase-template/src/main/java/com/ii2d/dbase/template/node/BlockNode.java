//~ generate by eclipse
package com.ii2d.dbase.template.node;

import java.io.IOException;

import com.ii2d.dbase.template.ParserException;
import com.ii2d.dbase.template.context.BlockContext;
import com.ii2d.dbase.template.context.Context;

/**
 * @author Doni
 * @since 2013-1-2
 * @version $id$
 * 
 */
public class BlockNode extends Node {
	
	private String blockName;
	private NodeList nodeList;

	public BlockNode(String blockName, NodeList nodeList) {
		this.blockName = blockName;
		this.nodeList = nodeList;
	}

	@Override
	public String render(Context context) throws IOException, ParserException {
		BlockContext blockContext = (BlockContext)context.get(ExtendsNode.BLOCK_CONTEXT);
		if(blockContext != null) {
			BlockNode node = blockContext.getBlock(getBlockName());
			return node.render(blockContext);
		}
		return nodeList.render(context);
	}

	public String getBlockName() {
		return blockName;
	}

}
