package com.reechauto.cloud.news.entity;

import java.io.Serializable;
import java.util.Date;

/**
* 绿驰汽车
* tableName: sys_privilege
* @author zhaoyb
*/
public class SysPrivilege extends SysPrivilegeKey implements Serializable {

    private Date createTime;
    private Long createBy;
    private static final long serialVersionUID = 1L;

    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Long getCreateBy() {
        return createBy;
    }
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
}