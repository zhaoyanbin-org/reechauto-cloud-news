package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class OrganizeDelByOrgIdRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "组织Id不可以为null")
	private Long orgId;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

}
