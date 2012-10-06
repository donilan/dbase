//~ generate by eclipse
package com.ii2d.dbase.mybatis;

import java.util.List;

/**
 * @author Doni
 * @since 2012-10-4
 * @version $id$
 * 
 */
public class Page {
	private int currentPage = 1;
	private Long count;
	private int rows = 10;
	private List<Object> data;
	
	public int getMaxPage() {
		int count = this.count.intValue();
		int maxPage = count / rows;
		if(count % rows > 0) {
			maxPage++;
		}
		return  maxPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}

	
}
