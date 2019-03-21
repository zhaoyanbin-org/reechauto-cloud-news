package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotBlank;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class PrivilegeDelByRoleRequest extends BaseRequest {

private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "roleId不可以为空")
	private String roleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
