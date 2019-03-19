package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class OrganizeAddRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "组织名称不可以为空")
	private String orgName;

	@NotNull(message = "上级组织Id不可以为null,顶级为0")
	private Long parentOrgId;

	@NotNull(message = "排序字段不可以为null,正序排列")
	private int sort;

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
