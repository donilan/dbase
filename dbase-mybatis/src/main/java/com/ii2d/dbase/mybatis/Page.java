//~ generate by eclipse
package com.ii2d.dbase.mybatis;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;

/**
 * @author Doni
 * @since 2012-10-4
 * @version $id$
 * 
 */
public class Page<E> extends ArrayList<E> {
	
	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactory.getLog(Page.class);
	
	private int currentPage = 1;
	private Long count;
	private int rows = 10;

	public Page() {
		super();
	}

	public Page(Collection<? extends E> c) {
		super(c);
	}

	public Page(int initialCapacity) {
		super(initialCapacity);
	}
	
	public static <T> Page<T> make(Collection<? extends T> c, RowBounds rowBounds, Long count) {
		Page<T> p = new Page<T>(c);
		if(LOG.isDebugEnabled()) {
			LOG.debug("date size: " + c.size() + ", after page created page size is: " + p.size());
		}
		int o = rowBounds.getOffset();
		int l = rowBounds.getLimit();
		p.rows = l;
		p.currentPage = (o+l+1)/l;
		p.count = count;
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
				.append(super.toString()).toString();
	}
}
