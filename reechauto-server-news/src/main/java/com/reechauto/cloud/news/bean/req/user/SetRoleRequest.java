package com.reechauto.cloud.news.bean.req.user;

import javax.validation.constraints.NotNull;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class SetRoleRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "目标用户不可以为null")
	private Long userId;
	
	private String roleIds;
	
	@NotNull(message = "当前登录用户Id不可以为null")
	private Long setter;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public Long getSetter() {
		return setter;
	}

	public void setSetter(Long setter) {
		this.setter = setter;
	}
	
}
