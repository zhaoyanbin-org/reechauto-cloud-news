package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.Min;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class RoleQueryRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	
	private String roleId;
	private String roleName;
	@Min(value = 1, message = "显示条数不能小于1")
	private int pageNum = 10;
	@Min(value = 0, message = "开始位置不能小于0")
	private int start = 0;
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
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
}
