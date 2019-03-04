package com.reechauto.cloud.news.entity;

import java.io.Serializable;
import java.util.Date;

/**
* 绿驰汽车
* tableName: news_notice
* @author zhaoyb
*/
public class NewsNotice implements Serializable {

    private String id;
    /**
     * 被通知人ID
     */
    private Long notifyId;
    /**
     * 资讯评论ID
     */
    private String newsShareId;
    /**
     * 对应评论或点赞的ID
     */
    private String relationId;
    /**
     * likes点赞，comment评论
     */
    private String noticeType;
    /**
     * 已读
     */
    private String isRead;
    /**
     * 读时间
     */
    private Date readTime;
    /**
     * 创建时间
     */
    private Date createTime;
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Long getNotifyId() {
        return notifyId;
    }
    public void setNotifyId(Long notifyId) {
        this.notifyId = notifyId;
    }
    public String getNewsShareId() {
        return newsShareId;
    }
    public void setNewsShareId(String newsShareId) {
        this.newsShareId = newsShareId;
    }
    public String getRelationId() {
        return relationId;
    }
    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }
    public String getNoticeType() {
        return noticeType;
    }
    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }
    public String getIsRead() {
        return isRead;
    }
    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }
    public Date getReadTime() {
        return readTime;
    }
    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}