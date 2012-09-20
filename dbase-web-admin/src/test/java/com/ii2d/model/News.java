//~ Generate by genthemall
package com.ii2d.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="news")
public class News extends com.ii2d.dbase.mybatis.model.BaseMyBatisModel {
	
	private static final long serialVersionUID = 1L;
	
	protected java.lang.Integer id;
	protected java.lang.String oldId;
	protected java.lang.Integer newsTypeId;
	protected java.lang.String content;
	protected java.lang.String title;
	protected java.lang.Integer status;
	protected java.lang.String source;
	protected java.util.Date createDate;
	
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
	
	public void setNewsTypeId(java.lang.Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}
	public java.lang.Integer getNewsTypeId() {
		return this.newsTypeId;
	}
	
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	public void setSource(java.lang.String source) {
		this.source = source;
	}
	public java.lang.String getSource() {
		return this.source;
	}
	
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	
	
	/**
	 * Generate by genthemall
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("com.ii2d.model.News.toString {\n\t");
		
		sb.append("id: [");
		sb.append(this.id);
		sb.append("], ");
		sb.append("oldId: [");
		sb.append(this.oldId);
		sb.append("], ");
		sb.append("newsTypeId: [");
		sb.append(this.newsTypeId);
		sb.append("], ");
		sb.append("status: [");
		sb.append(this.status);
		sb.append("], ");
		sb.append("source: [");
		sb.append(this.source);
		sb.append("], ");
		sb.append("createDate: [");
		sb.append(this.createDate);
		sb.append("], ");
		sb.append("\n}");
		return sb.toString();
	}
}