//~ generate by eclipse
package com.ii2d.dbase.template.token;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ii2d.dbase.template.ParserException;

/**
 * @author Doni
 * @since 2013-1-1
 * @version $id$
 * 
 */
public class BlockToken extends Token {
	
	private String _command;
	private List<String> _args;

	public BlockToken(String content, int lineNo) throws ParserException {
		super(StringUtils
				.trimToEmpty(content.substring(2, content.length() - 2)),
				lineNo);
		String[] bits = this.content.split("\\s+");
		if(bits == null || bits.length < 1) {
			throw new ParserException("Block tag cannot be null or empty.");
		}
		_command = bits[0];
		_args = new ArrayList<String>();
		for(int i = 1; i < bits.length; ++i) {
			_args.add(bits[i]);
		}
	}
	
	public String getCommand() {
		return this._command;
	}
	public List<String> getArgs() {
		return this._args;
	}

}
