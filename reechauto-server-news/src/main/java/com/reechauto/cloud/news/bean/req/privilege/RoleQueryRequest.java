package com.reechauto.cloud.news.bean.req.privilege;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class RoleQueryRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	
	private String roleId;
	private String roleName;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
