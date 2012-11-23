package com.ii2d.dbase.web.tag;

import javax.servlet.jsp.JspException;

public class TagListTable extends AbstractTag {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		this._w("<div class=\"list-table-wrapper\" ><table class=\"list-table\" >\n");
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		this._w("</table></div>\n");
		return super.doEndTag();
	}

	@Override
	public void release() {
		super.release();
	}
	
	
}
