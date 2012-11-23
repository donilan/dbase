package com.ii2d.dbase.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.jstl.core.LoopTagStatus;

import com.ii2d.dbase.web.tag.AbstractTag;

public class TagListTableTr extends AbstractTag {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		TagListTableBody bodyTag = (TagListTableBody)this.getParent();
		LoopTagStatus st = (LoopTagStatus)pageContext.getAttribute(bodyTag.getVarStatusId());
		StringBuilder clazzStr = new StringBuilder(20);
		if(st.getCount() % 2 == 0) {
			clazzStr.append("even ");
		} else {
			clazzStr.append("odd ");
		}
		if(st.isFirst()) {
			clazzStr.append("first");
		}else if(st.getCount() == 2) {
			clazzStr.append("second");
		}else if(st.getCount() == 3) {
			clazzStr.append("thrid");
		}else if(st.isLast()) {
			clazzStr.append("last");
		}
		_wf("<tr class=\"list-table-tr list-table-%d %s\" >", st.getCount(), clazzStr.toString());
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		_w("</tr>");
		return super.doEndTag();
	}

	
}
