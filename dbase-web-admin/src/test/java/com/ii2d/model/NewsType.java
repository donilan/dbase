//~ Generate by genthemall
package com.ii2d.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="newsType")
public class NewsType extends com.ii2d.dbase.mybatis.model.BaseMyBatisModel {
	
	private static final long serialVersionUID = 1L;
	
	protected java.lang.Integer id;
	protected java.lang.String oldId;
	protected java.lang.String treeCode;
	protected java.lang.String parentTreeCode;
	protected java.lang.String name;
	protected java.lang.Integer status;
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setOldId(java.lang.String oldId) {
		this.oldId = oldId;
	}
	public java.lang.String getOldId() {
		return this.oldId;
	}
	
	public void setTreeCode(java.lang.String treeCode) {
		this.treeCode = treeCode;
	}
	public java.lang.String getTreeCode() {
		return this.treeCode;
	}
	
	public void setParentTreeCode(java.lang.String parentTreeCode) {
		this.parentTreeCode = parentTreeCode;
	}
	public java.lang.String getParentTreeCode() {
		return this.parentTreeCode;
	}
	
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	
	/**
	 * Generate by genthemall
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("com.ii2d.model.NewsType.toString {\n\t");
		
		sb.append("id: [");
		sb.append(this.id);
		sb.append("], ");
		sb.append("oldId: [");
		sb.append(this.oldId);
		sb.append("], ");
		sb.append("treeCode: [");
		sb.append(this.treeCode);
		sb.append("], ");
		sb.append("parentTreeCode: [");
		sb.append(this.parentTreeCode);
		sb.append("], ");
		sb.append("name: [");
		sb.append(this.name);
		sb.append("], ");
		sb.append("status: [");
		sb.append(this.status);
		sb.append("], ");
		sb.append("\n}");
		return sb.toString();
	}
}