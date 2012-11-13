//~ generate by eclipse
package com.ii2d.dbase.mybatis;

import java.util.Collection;

/**
 * @author Doni
 * @since 2012-10-4
 * @version $id$
 * 
 */
public class Page<E> {
	
	private int currentPage = 1;
	private Long count;
	private int rows = 10;
	private Collection<E> data;

	public static <T> Page<T> make(PaginationResultHandler rh) {
		Page<T> p = new Page<T>();
		int o = rh.getSearchObject().getOffset();
		int l = rh.getSearchObject().getLimit();
		p.data = (Collection<T>)rh.getResult();
		p.rows = l;
		p.currentPage = (o+l+1)/l;
		p.count = rh.getCount();
		return p;
	}

	public int getMaxPage() {
		int count = this.count.intValue();
		int maxPage = count / rows;
		if (count % rows > 0) {
			maxPage++;
		}
		return maxPage;
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

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String toString() {
		return new StringBuffer(255).append("Page{ count: ").append(count)
				.append(", currentPage: ").append(currentPage)
				.append(", rows: ").append(rows).append(", maxPage: ").append(getMaxPage()).append(", data: ")
				.append(data).toString();
	}

	public Collection<E> getData() {
		return data;
	}

	public void setData(Collection<E> data) {
		this.data = data;
	}
}
