//~ generate by eclipse
package com.ii2d.dbase.web.model;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author Doni
 * @since 2012-12-4
 * @version $id$
 * 
 */
@javax.persistence.Entity
@javax.persistence.Table(name="II2D_MENU")
public class II2DMenu {
	
	protected Long id;
	protected String name;
	protected String menuGroup;
	protected String url;
	protected Long parentId;
	
	@Id
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	@Column
	public String getMenuGroup() {
		return menuGroup;
	}

	public void setMenuGroup(String menuGroup) {
		this.menuGroup = menuGroup;
	}
	
	
}
