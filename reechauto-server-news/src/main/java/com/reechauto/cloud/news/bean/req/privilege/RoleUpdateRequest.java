package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class RoleUpdateRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	@NotBlank(message = "roleId不可以为空")
	private String roleId;
	private String roleName;
	private String tips;
	@NotNull(message = "userId不可以为null")
	private Long userId;
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
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
