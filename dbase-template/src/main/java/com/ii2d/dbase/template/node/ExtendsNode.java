//~ generate by eclipse
package com.ii2d.dbase.template.node;

import java.io.IOException;

import com.ii2d.dbase.template.ParserException;
import com.ii2d.dbase.template.Template;
import com.ii2d.dbase.template.context.BlockContext;
import com.ii2d.dbase.template.context.Context;
import com.ii2d.dbase.template.finder.TemplateFinder;

/**
 * @author Doni
 * @since 2013-1-2
 * @version $id$
 * 
 */
public class ExtendsNode extends Node {
	
	public static final String BLOCK_CONTEXT = "_block_context"; 
	
	private String parentTmplName;
	private NodeList blocks;
	public ExtendsNode(NodeList nodeList, String parentTmplName) {
		this.blocks = nodeList.getNodeListByClass(BlockNode.class);
		this.parentTmplName = parentTmplName;
	}

	@Override
	public String render(Context context) throws IOException, ParserException {
		Template t = TemplateFinder.getTemplate(this.parentTmplName, context);
		NodeList parentNodeList = t.parser();
		BlockContext blockContext = (BlockContext)context.get(BLOCK_CONTEXT);
		if(blockContext == null) {
			blockContext = new BlockContext();
			context.put(BLOCK_CONTEXT, blockContext);
		}
		blockContext.addBlocks(blocks);
		return parentNodeList.render(context);
	}

}
