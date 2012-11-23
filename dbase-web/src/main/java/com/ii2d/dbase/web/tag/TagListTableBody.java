package com.ii2d.dbase.web.tag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.taglibs.standard.tag.common.core.ForEachSupport;

import com.ii2d.dbase.mybatis.Page;

public class TagListTableBody extends ForEachSupport {

	private static final Log LOG = LogFactory.getLog(TagListTableBody.class);
	private static final long serialVersionUID = 1L;
	public static final String RAW_ITEM_ID = "_RAW_ITEM";
	public static final String STATUS_ID = "_STATUS";
	public static final String ITEM_ID = "_ITEM";
	
	public void setItems(Object items) {
		rawItems = items;
	}

	@Override
	public void release() {
		super.release();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int doStartTag() throws JspException {
		if(rawItems == null) {
			LOG.error("No " + RAW_ITEM_ID + " in page scope.");
			rawItems = new ArrayList<Object>();
		} else if(rawItems instanceof Page) {
			rawItems = ((Page)rawItems).getData();
		}
		if(StringUtils.isBlank(itemId)) {
			itemId = ITEM_ID;
		}
		if(StringUtils.isBlank(statusId)) {
			statusId = STATUS_ID;
		}
		
		try {
			this.pageContext.getOut().write("<tbody>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			this.pageContext.getOut().write("</tbody>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

	public String getItemId() {
		return super.itemId;
	}
	public String getVarStatusId() {
		return super.statusId;
	}
}
