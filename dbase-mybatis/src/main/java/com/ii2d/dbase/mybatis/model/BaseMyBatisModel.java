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

	protected Map<String, Object> orEq = new HashMap<String, Object>();
	protected Map<String, Object> orLike = new HashMap<String, Object>();
	protected Map<String, Object> andEq = new HashMap<String, Object>();
	protected Map<String, Object> andLike = new HashMap<String, Object>();
	protected Map<String, Object> orBetween = new HashMap<String, Object>();
	protected Map<String, Object> andBetween = new HashMap<String, Object>();
	protected int limitStartRow;
	protected int limitEndRow;
	protected List<String> orderBy = new ArrayList<String>();
	protected boolean asc = true;
	
	public BaseMyBatisModel orEq(String prop, Object val) {
		if(val != null) {
			orEq.put(prop, val);
		}
		return this;
	}
	

	public BaseMyBatisModel orLike(String prop, String val) {
		if(val != null) {
			orLike.put(prop, val);
		}
		return this;
	}
	
	public BaseMyBatisModel andLike(String prop, String val) {
		if(val != null) {
			andLike.put(prop, val);
		}
		return this;
	}
	
	public BaseMyBatisModel andEq(String prop, String val) {
		if(val != null) {
			andEq.put(prop, val);
		}
		return this;
	}
	
	/**
	 * Add order by param to mybatis sql map
	 * @author Doni
	 * @since 2012-9-13
	 * @param column Column in table 
	 * @return this
	 */
	public BaseMyBatisModel orderBy(String column) {
		if(StringUtils.isNotEmpty(column) && column.length() < 40) {
			this.orderBy.add(column);
		}
		return this;
	}
	public BaseMyBatisModel orderBy(List<String> orderBy) {
		this.orderBy = orderBy;
		return this;
	}
	public BaseMyBatisModel limitStartRow(int limitStartRow) {
		this.limitStartRow = limitStartRow;
		return this;
	}
	public BaseMyBatisModel limitEndRow(int limitEndRow) {
		this.limitEndRow = limitEndRow;
		return this;
	}
	public BaseMyBatisModel asc(boolean asc) {
		this.asc = asc;
		return this;
	}

	public boolean isAsc() {
		return asc;
	}

	public Map<String, Object> getOrEq() {
		return orEq;
	}

	public Map<String, Object> getOrLike() {
		return orLike;
	}

	public Map<String, Object> getAndEq() {
		return andEq;
	}

	public Map<String, Object> getAndLike() {
		return andLike;
	}

	public List<String> getOrderBy() {
		return orderBy;
	}


	public int getLimitStartRow() {
		return limitStartRow;
	}

	public int getLimitEndRow() {
		return limitEndRow;
	}

	public Map<String, Object> getOrBetween() {
		return orBetween;
	}


	public void setOrBetween(Map<String, Object> orBetween) {
		this.orBetween = orBetween;
	}


	public Map<String, Object> getAndBetween() {
		return andBetween;
	}


	public void setAndBetween(Map<String, Object> andBetween) {
		this.andBetween = andBetween;
	}
	
}
