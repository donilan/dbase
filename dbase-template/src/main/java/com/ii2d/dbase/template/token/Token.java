//~ generate by eclipse
package com.ii2d.dbase.template.token;

/**
 * @author Doni
 * @since 2013-1-1
 * @version $id$
 * 
 */
public class Token {

	protected String content;
	protected int lineNo;

	public Token(String content, int lineNo) {
		this.content = content;
		this.lineNo = lineNo;
	}

	public String getContent() {
		return content;
	}
	public void setLineNo(int l) {
		this.lineNo = l;
	}
	public int getLineNo() {
		return lineNo;
	}

	@Override
	public String toString() {
		return String.format("Line: %s %s\n--------------", lineNo, content);
	}
	
	
}
