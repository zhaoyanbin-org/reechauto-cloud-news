package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class OrganizeUserAddRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "组织Id不可以为null")
	private Long orgId;

	@NotNull(message = "用户IDId不可以为null")
	private Long userId;

	@NotNull(message = "操作员Id不可以为null")
	private Long operBy;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOperBy() {
		return operBy;
	}

	public void setOperBy(Long operBy) {
		this.operBy = operBy;
	}

}
