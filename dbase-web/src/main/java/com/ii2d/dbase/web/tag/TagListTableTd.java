package com.ii2d.dbase.web.tag;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.util.HtmlUtils;

import com.ii2d.dbase.util.DDateUtils;

public class TagListTableTd extends AbstractTag {

	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactory.getLog(TagListTableTd.class);
	public static final String DEFAULT_NUMBER_FORMAT = "%d";
	public static final String DEFAULT_FLOAT_FORMAT = "%f";
	private String path;
	private String format;
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void release() {
		super.release();
		this.path = null;
		this.format = null;
	}


	@Override
	public int doStartTag() throws JspException {
		TagListTableBody bodyTag = (TagListTableBody)this.getParent().getParent();
		
		_wf("<td class=\"list-table-td %s\">&nbsp;", path);
		if(StringUtils.isNotBlank(path)) {
			Object it = pageContext.getAttribute(bodyTag.getItemId());
			if(it == null) {
				LOG.error("No item in page scope.");
			} else {
				Object val = null;
				try {
					val = BeanUtils.getProperty(it, path);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
				if(val != null) {
					_writeValue(val);
				}
			}
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		_w("</td>");
		return super.doEndTag();
	}

	private void _writeValue(Object obj) {
		if(obj instanceof String) {
			_w(HtmlUtils.htmlEscape((String)obj));
		}else if(obj instanceof Date) {
			if(format != null) {
				_w(new SimpleDateFormat(format).format((Date)obj));
			}else {
				_w(DDateUtils.dateFormat((Date)obj));
			}
		}else if(obj instanceof Float || obj instanceof Double){
			if(format == null) {
				format = DEFAULT_FLOAT_FORMAT;
			}
			_wf(format, obj);
		}else if (obj instanceof Number) {
			if(format == null) {
				format = DEFAULT_NUMBER_FORMAT;
			}
			_wf(format, obj);
		} 
	}
}
