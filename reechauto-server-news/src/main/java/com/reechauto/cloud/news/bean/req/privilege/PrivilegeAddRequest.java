package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class PrivilegeAddRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "roleId不可以为空")
	private String roleId;
	@NotNull(message = "menuIds不可以为null")
	private String  menuIds;
	@NotNull(message = "userId不可以为null")
	private Long userId;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
