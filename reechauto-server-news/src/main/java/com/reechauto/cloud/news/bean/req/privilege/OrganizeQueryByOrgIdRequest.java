package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class OrganizeQueryByOrgIdRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "组织Id不可以为null")
	private Long orgId;

	@NotNull(message = "是否显示全部组织参数不可以为null")
	private boolean isAll;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public boolean isAll() {
		return isAll;
	}

	public void setAll(boolean isAll) {
		this.isAll = isAll;
	}

}
