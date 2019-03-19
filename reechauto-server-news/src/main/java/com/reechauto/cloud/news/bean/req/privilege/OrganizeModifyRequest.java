package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class OrganizeModifyRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "要修改的组织Id不可以为null")
	private Long orgId;
	
	private String orgName;

	private Long parentOrgId;

	private int sort;

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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
