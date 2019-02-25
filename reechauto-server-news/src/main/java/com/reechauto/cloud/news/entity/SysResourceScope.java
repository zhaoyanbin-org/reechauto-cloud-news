package com.reechauto.cloud.news.entity;

import java.io.Serializable;

/**
* 绿驰汽车
* tableName: sys_resource_scope
* @author zhaoyb
*/
public class SysResourceScope implements Serializable {

    private Integer id;
    /**
     * 所属微服务ID
     */
    private String resourceServerId;
    /**
     * URL
     */
    private String url;
    /**
     * 范围ID
     */
    private String scope;
    /**
     * 范围说明
     */
    private String scopeTips;
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getResourceServerId() {
        return resourceServerId;
    }
    public void setResourceServerId(String resourceServerId) {
        this.resourceServerId = resourceServerId;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getScope() {
        return scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }
    public String getScopeTips() {
        return scopeTips;
    }
    public void setScopeTips(String scopeTips) {
        this.scopeTips = scopeTips;
    }
}