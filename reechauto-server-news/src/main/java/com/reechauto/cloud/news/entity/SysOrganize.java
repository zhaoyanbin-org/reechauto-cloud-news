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
     * 排序
     */
    private Integer sort;
    /**
     * Y/N是否可用
     */
    private String isEnable;
    private String parentOrgIdAll;
    private String parentOrgNameAll;
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
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getIsEnable() {
        return isEnable;
    }
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
    public String getParentOrgIdAll() {
        return parentOrgIdAll;
    }
    public void setParentOrgIdAll(String parentOrgIdAll) {
        this.parentOrgIdAll = parentOrgIdAll;
    }
    public String getParentOrgNameAll() {
        return parentOrgNameAll;
    }
    public void setParentOrgNameAll(String parentOrgNameAll) {
        this.parentOrgNameAll = parentOrgNameAll;
    }
}