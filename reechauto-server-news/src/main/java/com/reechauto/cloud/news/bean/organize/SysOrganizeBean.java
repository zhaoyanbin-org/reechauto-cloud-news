package com.reechauto.cloud.news.bean.organize;

import java.io.Serializable;
import java.util.List;

public class SysOrganizeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 组织ID
	 */
	private Long orgId;
	/**
	 * 组织名称
	 */
	private String orgName;
	/**
	 * 上级组织ID
	 */
	private Long parentOrgId;
	/**
	 * 组织等级
	 */
	private Integer orgLevel;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * Y/N是否可用
	 */
	private String isEnable;

	/**
	 * 下级组织
	 */
	private List<SysOrganizeBean> childOrg;

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

	public Long getParentOrgId() {
		return parentOrgId;
	}

	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	public Integer getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public List<SysOrganizeBean> getChildOrg() {
		return childOrg;
	}

	public void setChildOrg(List<SysOrganizeBean> childOrg) {
		this.childOrg = childOrg;
	}

}
