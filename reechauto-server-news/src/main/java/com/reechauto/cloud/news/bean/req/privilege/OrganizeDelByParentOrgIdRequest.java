package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class OrganizeDelByParentOrgIdRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "组织父Id不可以为null")
	private Long parentOrgId;

	public Long getParentOrgId() {
		return parentOrgId;
	}

	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

}
