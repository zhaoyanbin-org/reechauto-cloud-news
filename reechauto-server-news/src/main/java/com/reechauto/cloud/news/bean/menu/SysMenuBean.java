package com.reechauto.cloud.news.bean.menu;

import java.util.List;
import com.reechauto.cloud.news.entity.SysMenu;

public class SysMenuBean extends SysMenu{

	private static final long serialVersionUID = 1L;
	
	private List<SysMenuBean> childMenu;
	
	private String isSelected;
	
	public List<SysMenuBean> getChildMenu() {
		return childMenu;
	}
	public void setChildMenu(List<SysMenuBean> childMenu) {
		this.childMenu = childMenu;
	}
	public String getIsSelected() {
		return isSelected;
	}
	public void setIsSelected(String isSelected) {
		this.isSelected = isSelected;
	}
	
}
