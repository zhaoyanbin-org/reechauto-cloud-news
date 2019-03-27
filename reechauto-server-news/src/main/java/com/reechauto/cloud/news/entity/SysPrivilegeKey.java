package com.reechauto.cloud.news.entity;

import java.io.Serializable;

/**
* 绿驰汽车
* tableName: sys_privilege
* @author zhaoyb
*/
public class SysPrivilegeKey implements Serializable {

    private String roleId;
    private Long menuId;
    private static final long serialVersionUID = 1L;

    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public Long getMenuId() {
        return menuId;
    }
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}