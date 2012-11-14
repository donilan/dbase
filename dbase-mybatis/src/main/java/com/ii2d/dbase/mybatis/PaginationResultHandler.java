//~ generate by eclipse
package com.ii2d.dbase.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;


/**
 * @author Doni
 * @since 2012-11-12
 * @version $id$
 * 
 */
public class PaginationResultHandler implements ResultHandler {

	protected List<Object> result = new ArrayList<Object>();
	protected SearchObject searchObject;
	protected Long count = 0L;

	@Override
	public void handleResult(ResultContext context) {
		result.add(context.getResultObject());
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
	public List<Object> getResult() {
		return result;
	}

	public void setResult(List<Object> result) {
		this.result = result;
	}

	public SearchObject getSearchObject() {
		return searchObject;
	}

	public void setSearchObject(SearchObject searchObject) {
		this.searchObject = searchObject;
	}
}
