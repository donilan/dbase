package com.ii2d.dbase.web.tag;

import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringUtils;

import com.ii2d.dbase.util.DStringUtils;
import com.ii2d.dbase.web.tag.AbstractTag;

public class TagTHead extends AbstractTag {

	private static final long serialVersionUID = 1L;
	
	private String headArray;
	private String widthArray;
	
	public void setHeadArray(String headArray) {
		this.headArray = headArray;
	}

	public void setWidthArray(String widthArray) {
		this.widthArray = widthArray;
	}

	@Override
	public int doEndTag() throws JspException {
		List<List<String>> paramList = DStringUtils.splitStrings(headArray, widthArray);
		List<String> hL = paramList.get(0);
		List<String> wL = paramList.get(1);
		_w("<thead><tr>");
		for(int i = 0; i < hL.size(); ++i) {
			String h = hL.get(i);
			String w = wL.get(i);
			String width = "";
			if(StringUtils.isNotBlank(w)) {
				width = String.format("width=\"%s\"", w);
			}
			_wf("<th %s>%s</th>", width, h);
		}
		_w("</tr></thead>");
		return super.doEndTag();
	}
	
	
}
