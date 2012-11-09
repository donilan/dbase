//~ generate by eclipse
package com.ii2d.dbase.web.tag;

import java.util.Date;

import javax.servlet.jsp.JspException;

import com.ii2d.dbase.util.DDateUtils;

/**
 * @author Doni
 * @since 2012-11-9
 * @version $id$
 * 
 */
public class TagDatetime extends AbstractTag {

	private static final long serialVersionUID = 1L;
	
	protected Date date;
	
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int doEndTag() throws JspException {
		_w(DDateUtils.datetimeFormat(date));
		return super.doEndTag();
	}
}
