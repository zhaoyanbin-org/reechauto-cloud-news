package com.reechauto.cloud.news.bean.organize;

import java.io.Serializable;
import java.util.Date;

public class UserOrganizeDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 帐号
	 */
	private String account;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * email
	 */
	private String email;
	/**
	 * 身份证
	 */
	private String idcard;
	/**
	 * (男/女/保密)
	 */
	private String sex;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 头像url
	 */
	private String imgUrl;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 用户状态：OK,LOCK
	 */
	private String userStatus;
	/**
	 * Y/N(已删除/未删除)
	 */
	private String isDel;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date modifyTime;
	/**
	 * 组织ID
	 */
	private Long orgId;
	/**
	 * 组织名称
	 */
	private String orgName;
	/**
	 * 上级组织ID集合
	 */
	private String parentOrgIdAll;
	/**
	 * 上级组织名称集合
	 */
	private String parentOrgNameAll;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getParentOrgIdAll() {
		return parentOrgIdAll;
	}

	public void setParentOrgIdAll(String parentOrgIdAll) {
		this.parentOrgIdAll = parentOrgIdAll;
	}

	public String getParentOrgNameAll() {
		return parentOrgNameAll;
	}

	public void setParentOrgNameAll(String parentOrgNameAll) {
		this.parentOrgNameAll = parentOrgNameAll;
	}

}
