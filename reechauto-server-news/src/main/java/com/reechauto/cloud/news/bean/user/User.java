package com.reechauto.cloud.news.bean.user;

import java.util.List;
import com.reechauto.cloud.news.entity.SysRole;
import com.reechauto.cloud.news.entity.UserDetails;

public class User extends UserDetails {

	private static final long serialVersionUID = 1L;
	private List<SysRole> roles;
	public List<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
	
}
