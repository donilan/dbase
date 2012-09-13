//~ generate by eclipse
package com.ii2d.dbase.mybatis.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Doni
 * @since 2012-9-13
 * @version $id$
 * 
 */
public class BaseMyBatisModel implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Map<String, Object> or;
	protected Map<String, Object> like;
	protected List<String> orderBy;
	protected boolean asc = true;
	
	/**
	 * Add or param to mybatis sql map
	 * @author Doni
	 * @since 2012-9-13
	 * @param prop Property
	 * @param val Value for search
	 * @return false if val is null
	 */
	public boolean or(String prop, Object val) {
		if(or == null) or = new HashMap<String, Object>();
		if(val != null) {
			or.put(prop, val);
			return true;
		}
		return false;
	}
	
	/**
	 * Add like param to mybatis sql map
	 * @author Doni
	 * @since 2012-9-13
	 * @param prop Property
	 * @param val Value for search
	 * @return false if val is null
	 */
	public boolean like(String prop, Object val) {
		if(like == null) like = new HashMap<String, Object>();
		if(val != null) {
			like.put(prop, val);
			return true;
		}
		return false;
	}
	
	/**
	 * Add order by param to mybatis sql map
	 * @author Doni
	 * @since 2012-9-13
	 * @param column Column in table 
	 * @return false if column is null
	 */
	public boolean orderBy(String column) {
		if(this.orderBy == null) this.orderBy = new ArrayList<String>();
		if(StringUtils.isNotEmpty(column)) {
			return this.orderBy.add(column);
		}
		return false;
	}

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	public Map<String, Object> getOr() {
		return or;
	}

	public Map<String, Object> getLike() {
		return like;
	}

	public List<String> getOrderBy() {
		return orderBy;
	}
	
}
