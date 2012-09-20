//~ Generate by genthemall
package com.ii2d.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="shop")
public class Shop extends com.ii2d.dbase.mybatis.model.BaseMyBatisModel {
	
	private static final long serialVersionUID = 1L;
	
	protected java.lang.Integer id;
	protected java.lang.Integer shopTypeId;
	protected java.lang.String oldId;
	protected java.lang.Integer userId;
	protected java.lang.Integer areaId;
	protected java.lang.String name;
	protected java.lang.Integer status;
	protected java.lang.Boolean deleted;
	protected java.util.Date createDate;
	protected java.lang.String description;
	protected java.lang.String contact;
	protected java.lang.String zipCode;
	protected java.lang.String telephone;
	protected java.lang.String phone;
	protected java.lang.String fax;
	protected java.lang.String email;
	protected java.lang.String address;
	protected java.lang.Integer showOrder;
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setShopTypeId(java.lang.Integer shopTypeId) {
		this.shopTypeId = shopTypeId;
	}
	public java.lang.Integer getShopTypeId() {
		return this.shopTypeId;
	}
	
	public void setOldId(java.lang.String oldId) {
		this.oldId = oldId;
	}
	public java.lang.String getOldId() {
		return this.oldId;
	}
	
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setAreaId(java.lang.Integer areaId) {
		this.areaId = areaId;
	}
	public java.lang.Integer getAreaId() {
		return this.areaId;
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
	
	public void setDeleted(java.lang.Boolean deleted) {
		this.deleted = deleted;
	}
	public java.lang.Boolean getDeleted() {
		return this.deleted;
	}
	
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	
	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	public java.lang.String getDescription() {
		return this.description;
	}
	
	public void setContact(java.lang.String contact) {
		this.contact = contact;
	}
	public java.lang.String getContact() {
		return this.contact;
	}
	
	public void setZipCode(java.lang.String zipCode) {
		this.zipCode = zipCode;
	}
	public java.lang.String getZipCode() {
		return this.zipCode;
	}
	
	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}
	public java.lang.String getTelephone() {
		return this.telephone;
	}
	
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	public java.lang.String getPhone() {
		return this.phone;
	}
	
	public void setFax(java.lang.String fax) {
		this.fax = fax;
	}
	public java.lang.String getFax() {
		return this.fax;
	}
	
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	public java.lang.String getAddress() {
		return this.address;
	}
	
	public void setShowOrder(java.lang.Integer showOrder) {
		this.showOrder = showOrder;
	}
	public java.lang.Integer getShowOrder() {
		return this.showOrder;
	}
	
	
	/**
	 * Generate by genthemall
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("com.ii2d.model.Shop.toString {\n\t");
		
		sb.append("id: [");
		sb.append(this.id);
		sb.append("], ");
		sb.append("shopTypeId: [");
		sb.append(this.shopTypeId);
		sb.append("], ");
		sb.append("oldId: [");
		sb.append(this.oldId);
		sb.append("], ");
		sb.append("userId: [");
		sb.append(this.userId);
		sb.append("], ");
		sb.append("areaId: [");
		sb.append(this.areaId);
		sb.append("], ");
		sb.append("name: [");
		sb.append(this.name);
		sb.append("], ");
		sb.append("status: [");
		sb.append(this.status);
		sb.append("], ");
		sb.append("deleted: [");
		sb.append(this.deleted);
		sb.append("], ");
		sb.append("createDate: [");
		sb.append(this.createDate);
		sb.append("], ");
		sb.append("contact: [");
		sb.append(this.contact);
		sb.append("], ");
		sb.append("zipCode: [");
		sb.append(this.zipCode);
		sb.append("], ");
		sb.append("telephone: [");
		sb.append(this.telephone);
		sb.append("], ");
		sb.append("phone: [");
		sb.append(this.phone);
		sb.append("], ");
		sb.append("fax: [");
		sb.append(this.fax);
		sb.append("], ");
		sb.append("email: [");
		sb.append(this.email);
		sb.append("], ");
		sb.append("address: [");
		sb.append(this.address);
		sb.append("], ");
		sb.append("showOrder: [");
		sb.append(this.showOrder);
		sb.append("], ");
		sb.append("\n}");
		return sb.toString();
	}
}