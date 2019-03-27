package com.reechauto.cloud.news.bean.menu;

import java.io.Serializable;

public class MenuId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long  menuId;
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
}
