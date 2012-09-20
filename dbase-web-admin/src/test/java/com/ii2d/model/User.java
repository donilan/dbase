//~ Generate by genthemall
package com.ii2d.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class User extends com.ii2d.dbase.mybatis.model.BaseMyBatisModel {
	
	private static final long serialVersionUID = 1L;
	
	protected java.lang.Integer id;
	protected java.lang.Integer userTypeId;
	protected java.lang.String oldId;
	protected java.lang.String loginId;
	protected java.lang.String password;
	protected java.lang.Integer status;
	protected java.util.Date createDate;
	protected java.lang.String name;
	protected java.lang.String idCard;
	protected java.lang.String zipCode;
	protected java.lang.String phone;
	protected java.lang.String telephone;
	protected java.lang.String areaCode;
	protected java.lang.String address;
	protected java.util.Date lastLoginTime;
	protected java.lang.String lastLoginIp;
	protected java.util.Date recentLoginTime;
	protected java.lang.String recentLoginIp;
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setUserTypeId(java.lang.Integer userTypeId) {
		this.userTypeId = userTypeId;
	}
	public java.lang.Integer getUserTypeId() {
		return this.userTypeId;
	}
	
	public void setOldId(java.lang.String oldId) {
		this.oldId = oldId;
	}
	public java.lang.String getOldId() {
		return this.oldId;
	}
	
	public void setLoginId(java.lang.String loginId) {
		this.loginId = loginId;
	}
	public java.lang.String getLoginId() {
		return this.loginId;
	}
	
	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setIdCard(java.lang.String idCard) {
		this.idCard = idCard;
	}
	public java.lang.String getIdCard() {
		return this.idCard;
	}
	
	public void setZipCode(java.lang.String zipCode) {
		this.zipCode = zipCode;
	}
	public java.lang.String getZipCode() {
		return this.zipCode;
	}
	
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	public java.lang.String getPhone() {
		return this.phone;
	}
	
	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}
	public java.lang.String getTelephone() {
		return this.telephone;
	}
	
	public void setAreaCode(java.lang.String areaCode) {
		this.areaCode = areaCode;
	}
	public java.lang.String getAreaCode() {
		return this.areaCode;
	}
	
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	public java.lang.String getAddress() {
		return this.address;
	}
	
	public void setLastLoginTime(java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public java.util.Date getLastLoginTime() {
		return this.lastLoginTime;
	}
	
	public void setLastLoginIp(java.lang.String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public java.lang.String getLastLoginIp() {
		return this.lastLoginIp;
	}
	
	public void setRecentLoginTime(java.util.Date recentLoginTime) {
		this.recentLoginTime = recentLoginTime;
	}
	public java.util.Date getRecentLoginTime() {
		return this.recentLoginTime;
	}
	
	public void setRecentLoginIp(java.lang.String recentLoginIp) {
		this.recentLoginIp = recentLoginIp;
	}
	public java.lang.String getRecentLoginIp() {
		return this.recentLoginIp;
	}
	
	
	/**
	 * Generate by genthemall
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("com.ii2d.model.User.toString {\n\t");
		
		sb.append("id: [");
		sb.append(this.id);
		sb.append("], ");
		sb.append("userTypeId: [");
		sb.append(this.userTypeId);
		sb.append("], ");
		sb.append("oldId: [");
		sb.append(this.oldId);
		sb.append("], ");
		sb.append("loginId: [");
		sb.append(this.loginId);
		sb.append("], ");
		sb.append("password: [");
		sb.append(this.password);
		sb.append("], ");
		sb.append("status: [");
		sb.append(this.status);
		sb.append("], ");
		sb.append("createDate: [");
		sb.append(this.createDate);
		sb.append("], ");
		sb.append("name: [");
		sb.append(this.name);
		sb.append("], ");
		sb.append("idCard: [");
		sb.append(this.idCard);
		sb.append("], ");
		sb.append("zipCode: [");
		sb.append(this.zipCode);
		sb.append("], ");
		sb.append("phone: [");
		sb.append(this.phone);
		sb.append("], ");
		sb.append("telephone: [");
		sb.append(this.telephone);
		sb.append("], ");
		sb.append("areaCode: [");
		sb.append(this.areaCode);
		sb.append("], ");
		sb.append("address: [");
		sb.append(this.address);
		sb.append("], ");
		sb.append("lastLoginTime: [");
		sb.append(this.lastLoginTime);
		sb.append("], ");
		sb.append("lastLoginIp: [");
		sb.append(this.lastLoginIp);
		sb.append("], ");
		sb.append("recentLoginTime: [");
		sb.append(this.recentLoginTime);
		sb.append("], ");
		sb.append("recentLoginIp: [");
		sb.append(this.recentLoginIp);
		sb.append("], ");
		sb.append("\n}");
		return sb.toString();
	}
}