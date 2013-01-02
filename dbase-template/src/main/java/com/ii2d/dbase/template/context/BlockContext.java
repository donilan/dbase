//~ generate by eclipse
package com.ii2d.dbase.template.context;

import java.util.HashMap;
import java.util.Map;

import com.ii2d.dbase.template.node.BlockNode;
import com.ii2d.dbase.template.node.Node;
import com.ii2d.dbase.template.node.NodeList;

/**
 * @author Doni
 * @since 2013-1-2
 * @version $id$
 * 
 */
public class BlockContext extends Context {

	private static final long serialVersionUID = 1L;
	
	private Map<String, BlockNode> blocks = new HashMap<String, BlockNode>();

	public void addBlocks(NodeList blockNodes) {
		for(Node n: blockNodes) {
			if(n instanceof BlockNode) {
				BlockNode node = (BlockNode)n;
				if(!blocks.containsKey(node.getBlockName())) {
					blocks.put(node.getBlockName(), node);
				}
			}
		}
	}
	
	public BlockNode getBlock(String blockName) {
		return this.blocks.get(blockName);
	}
}
