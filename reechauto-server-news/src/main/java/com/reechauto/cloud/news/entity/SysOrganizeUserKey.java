package com.reechauto.cloud.news.entity;

import java.io.Serializable;

/**
* 绿驰汽车
* tableName: sys_organize_user
* @author zhaoyb
*/
public class SysOrganizeUserKey implements Serializable {

    private Long userId;
    private Long orgId;
    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getOrgId() {
        return orgId;
    }
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}