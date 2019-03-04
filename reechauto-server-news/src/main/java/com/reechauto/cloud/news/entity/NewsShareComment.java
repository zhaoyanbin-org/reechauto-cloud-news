package com.reechauto.cloud.news.entity;

import java.io.Serializable;
import java.util.Date;

/**
* 绿驰汽车
* tableName: news_share_comment
* @author zhaoyb
*/
public class NewsShareComment implements Serializable {

    private String id;
    /**
     * 资迅动态ID
     */
    private String newsShareId;
    /**
     * 评论内容
     */
    private String commentContext;
    /**
     * 评论人ID
     */
    private Long commentUserId;
    /**
     * 评论人昵称
     */
    private String commentUserNickName;
    /**
     * 评论人头像
     */
    private String commentUserHeadPortraitUrl;
    /**
     * Y:显示,N:删除
     */
    private String commentStatus;
    private Date createTime;
    private Date modifyTime;
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNewsShareId() {
        return newsShareId;
    }
    public void setNewsShareId(String newsShareId) {
        this.newsShareId = newsShareId;
    }
    public String getCommentContext() {
        return commentContext;
    }
    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
    }
    public Long getCommentUserId() {
        return commentUserId;
    }
    public void setCommentUserId(Long commentUserId) {
        this.commentUserId = commentUserId;
    }
    public String getCommentUserNickName() {
        return commentUserNickName;
    }
    public void setCommentUserNickName(String commentUserNickName) {
        this.commentUserNickName = commentUserNickName;
    }
    public String getCommentUserHeadPortraitUrl() {
        return commentUserHeadPortraitUrl;
    }
    public void setCommentUserHeadPortraitUrl(String commentUserHeadPortraitUrl) {
        this.commentUserHeadPortraitUrl = commentUserHeadPortraitUrl;
    }
    public String getCommentStatus() {
        return commentStatus;
    }
    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}