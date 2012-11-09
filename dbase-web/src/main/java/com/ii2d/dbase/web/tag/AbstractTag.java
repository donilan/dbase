//~ generate by eclipse
package com.ii2d.dbase.web.tag;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Doni
 * @since 2012-11-9
 * @version $id$
 * 
 */
public class AbstractTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * @see {@link java.lang.String.format(String, Object...)}
	 * @author Doni
	 * @since 2012-11-9
	 */
	protected void _wf(String fmt, Object... objs) {
		_w(String.format(fmt, objs));
	}
	
	protected void _w(String str) {
		try {
			this.pageContext.getOut().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
