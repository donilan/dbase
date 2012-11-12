//~ generate by eclipse
package com.ii2d.dbase.mybatis.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

/**
 * @author Doni
 * @since 2012-9-13
 * @version $id$
 * 
 */
public class BaseMyBatisModel implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Map<String, Object> _orEq = new HashMap<String, Object>();
	protected Map<String, Object> _orLike = new HashMap<String, Object>();
	protected Map<String, Object> _andEq = new HashMap<String, Object>();
	protected Map<String, Object> _andLike = new HashMap<String, Object>();
	protected Map<String, Object> _orBetween = new HashMap<String, Object>();
	protected Map<String, Object> _andBetween = new HashMap<String, Object>();
	protected Map<String, String> _orderBy = new HashMap<String, String>();
	protected Map<String, Integer> _pagination = new HashMap<String, Integer>();
	
	
	public RowBounds getRowBounds() {
		Integer page = _pagination.get("page");
		if(page != null) {
			if(page < 1) {
				page = 1;
			}
			Integer rows = _pagination.get("rows");
			if(rows == null || rows < 1) {
				rows = 10;
			}
			return new RowBounds((page-1)* rows, rows);
		}
		return null;
	}
	
	public BaseMyBatisModel orEq(String prop, Object val) {
		if(val != null) {
			_orEq.put(prop, val);
		}
		return this;
	}
	

	public BaseMyBatisModel orLike(String prop, String val) {
		if(val != null) {
			_orLike.put(prop, val);
		}
		return this;
	}
	
	public BaseMyBatisModel andLike(String prop, String val) {
		if(val != null) {
			_andLike.put(prop, val);
		}
		return this;
	}
	
	public BaseMyBatisModel andEq(String prop, String val) {
		if(val != null) {
			_andEq.put(prop, val);
		}
		return this;
	}
	
	/**
	 * @see #paging(Integer, Integer)
	 */
	public BaseMyBatisModel paging(Integer page) {
		return paging(page, null);
	}
	/**
	 * Pagination method
	 * @author Doni
	 * @since 2012-11-12
	 * @return
	 */
	public BaseMyBatisModel paging(Integer page, Integer rows) {
		_pagination.put("page", page);
		_pagination.put("rows", rows);
		return this;
	}
	
	/**
	 * Add order by param to mybatis sql map
	 * @author Doni
	 * @since 2012-9-13
	 * @param column Column in table 
	 * @return this
	 */
	public BaseMyBatisModel orderBy(String column, boolean isAsc) {
		_orderBy.put(column, isAsc? "ASC": "DESC");
		return this;
	}
	public BaseMyBatisModel orderBy(String column) {
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
