package com.reechauto.cloud.news.entity;

import java.io.Serializable;
import java.util.Date;

/**
* 绿驰汽车
* tableName: news_version
* @author zhaoyb
*/
public class NewsVersion implements Serializable {

    private Integer id;
    private String versionNum;
    private String versionName;
    private String versionInfo;
    private Date createTime;
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getVersionNum() {
        return versionNum;
    }
    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }
    public String getVersionName() {
        return versionName;
    }
    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }
    public String getVersionInfo() {
        return versionInfo;
    }
    public void setVersionInfo(String versionInfo) {
        this.versionInfo = versionInfo;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}