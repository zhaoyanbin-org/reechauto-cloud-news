package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class OrganizeUserQueryByOrgIdRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "组织Id不可以为null")
	private Long orgId;

	@Min(value = 1, message = "页面条数不能小于1")
	private int pageNum = 10;

	@Min(value = 1, message = "页码不能小于1")
	private int pageSize = 1;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
