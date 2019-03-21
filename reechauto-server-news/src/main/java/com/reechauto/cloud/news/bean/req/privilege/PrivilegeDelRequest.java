package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class PrivilegeDelRequest extends BaseRequest {

    private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "roleId不可以为空")
	private String roleId;
	@NotNull(message = "menuId不可以为null")
	private Integer menuId;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}
