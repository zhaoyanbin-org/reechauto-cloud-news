package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class OrganizeQueryByParentOrgIdRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "组织父Id不可以为null")
	private Long parentOrgId;

	@NotNull(message = "是否显示全部组织参数不可以为null")
	private boolean isAll;

	public Long getParentOrgId() {
		return parentOrgId;
	}

	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	public boolean isAll() {
		return isAll;
	}

	public void setAll(boolean isAll) {
		this.isAll = isAll;
	}

}
