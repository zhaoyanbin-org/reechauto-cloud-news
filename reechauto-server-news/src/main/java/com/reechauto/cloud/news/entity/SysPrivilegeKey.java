package com.reechauto.cloud.news.entity;

import java.io.Serializable;

/**
* 绿驰汽车
* tableName: sys_privilege
* @author zhaoyb
*/
public class SysPrivilegeKey implements Serializable {

    private String roleId;
    private Integer menuId;
    private static final long serialVersionUID = 1L;

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