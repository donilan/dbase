//~ generate by eclipse
package com.ii2d.dbase.mybatis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Doni
 * @since 2012-9-13
 * @version $id$
 * 
 */
public class SearchObject {

	protected Map<String, Object> _orEq = new HashMap<String, Object>();
	protected Map<String, Object> _orLike = new HashMap<String, Object>();
	protected Map<String, Object> _andEq = new HashMap<String, Object>();
	protected Map<String, Object> _andLike = new HashMap<String, Object>();
	protected Map<String, Object> _orBetween = new HashMap<String, Object>();
	protected Map<String, Object> _andBetween = new HashMap<String, Object>();
	protected Map<String, String> _orderBy = new HashMap<String, String>();
	protected Map<String, Integer> _pagination = new HashMap<String, Integer>();
	protected Map<String, Object> _param = new HashMap<String, Object>();
	
	private static final String PAGE = "page";
	private static final String LIMIT = "limit";
	private static final String ASC = "ASC";
	private static final String DESC = "DESC";
			
	public int getOffset() {
		Integer page = _pagination.get(PAGE);
		if(page != null) {
			if(page < 1) {
				page = 1;
			}
			Integer rows = _pagination.get(LIMIT);
			if(rows == null || rows < 1) {
				rows = 10;
			}
			return (page-1)* rows;
		}
		return 0;
	}
	public int getLimit() {
		Integer limit = _pagination.get(LIMIT);
		if(limit == null || limit < 1) {
			return 10;
		}
		return limit;
	}
	
	public SearchObject orEq(String prop, Object val) {
		if(val != null) {
			_orEq.put(prop, val);
		}
		return this;
	}
	

	public SearchObject orLike(String prop, String val) {
		if(val != null) {
			_orLike.put(prop, val);
		}
		return this;
	}
	
	public SearchObject andLike(String prop, String val) {
		if(val != null) {
			_andLike.put(prop, val);
		}
		return this;
	}
	
	public SearchObject andEq(String prop, String val) {
		if(val != null) {
			_andEq.put(prop, val);
		}
		return this;
	}
	
	/**
	 * @see #paging(Integer, Integer)
	 */
	public SearchObject paging(Integer page) {
		return paging(page, null);
	}
	/**
	 * Pagination method
	 * @author Doni
	 * @since 2012-11-12
	 * @return
	 */
	public SearchObject paging(Integer page, Integer limit) {
		_pagination.put(PAGE, page);
		_pagination.put(LIMIT, limit);
		return this;
	}
	
	public Object addParam(String key, Object val) {
		_param.put(key, val);
		return val;
	}
	
	/**
	 * Add order by param to mybatis sql map
	 * @author Doni
	 * @since 2012-9-13
	 * @param column Column in table 
	 * @return this
	 */
	public SearchObject orderBy(String column, boolean isAsc) {
		_orderBy.put(column, isAsc? ASC: DESC);
		return this;
	}
	public SearchObject orderBy(String column) {
		orderBy(column, true);
		return this;
	}

	public Map<String, Object> getOrEq() {
		return _orEq;
	}

	public Map<String, Object> getOrLike() {
		return _orLike;
	}

	public Map<String, Object> getAndEq() {
		return _andEq;
	}

	public Map<String, Object> getAndLike() {
		return _andLike;
	}

	public Map<String, String> getOrderBy() {
		return _orderBy;
	}

	public Map<String, Object> getOrBetween() {
		return _orBetween;
	}
	public Map<String, Object> getParam() {
		return _param;
	}


	public void setOrBetween(Map<String, Object> orBetween) {
		this._orBetween = orBetween;
	}


	public Map<String, Object> getAndBetween() {
		return _andBetween;
	}

	public void setAndBetween(Map<String, Object> andBetween) {
		this._andBetween = andBetween;
	}

	public Map<String, Integer> getPagination() {
		return _pagination;
	}

	
}
