//~ generate by eclipse
package com.ii2d.dbase.commons.model;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author Doni
 * @since 2012-12-4
 * @version $id$
 * 
 */
@javax.persistence.Entity
@javax.persistence.Table(name="MENU")
public class Menu {
	
	protected int id;
	protected String menuName;
	protected String menuGroup;
	protected String menuUrl;
	protected int parentId;
	
	@Id
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	@Column
	public String getMenuGroup() {
		return menuGroup;
	}

	public void setMenuGroup(String menuGroup) {
		this.menuGroup = menuGroup;
	}
	@Column
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	@Column
	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	
}
