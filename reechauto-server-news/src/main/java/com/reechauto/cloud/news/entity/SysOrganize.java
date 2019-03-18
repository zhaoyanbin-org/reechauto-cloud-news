package com.reechauto.cloud.news.entity;

import java.io.Serializable;

/**
* 绿驰汽车
* tableName: sys_organize
* @author zhaoyb
*/
public class SysOrganize implements Serializable {

    /**
     * 组织ID
     */
    private Long orgId;
    /**
     * 组织名称
     */
    private String orgName;
    /**
     * 上级组织ID
     */
    private Long parentOrgId;
    /**
     * 组织等级
     */
    private Integer orgLevel;
    /**
     * Y/N是否可用
     */
    private String isEnable;
    private static final long serialVersionUID = 1L;

    public Long getOrgId() {
        return orgId;
    }
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
    public String getOrgName() {
        return orgName;
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public Long getParentOrgId() {
        return parentOrgId;
    }
    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
    }
    public Integer getOrgLevel() {
        return orgLevel;
    }
    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }
    public String getIsEnable() {
        return isEnable;
    }
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
}