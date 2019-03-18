package com.reechauto.cloud.news.entity;

import java.io.Serializable;
import java.util.Date;

/**
* 绿驰汽车
* tableName: news_share_likes
* @author zhaoyb
*/
public class NewsShareLikes implements Serializable {

    private String id;
    private String newsShareId;
    /**
     * 点赞人ID
     */
    private Long likesUserId;
    /**
     * 点赞人昵称
     */
    private String likesUserNickName;
    /**
     * 点赞人头像
     */
    private String likesUserHeadPortraitUrl;
    private Date likesTime;
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
    public Long getLikesUserId() {
        return likesUserId;
    }
    public void setLikesUserId(Long likesUserId) {
        this.likesUserId = likesUserId;
    }
    public String getLikesUserNickName() {
        return likesUserNickName;
    }
    public void setLikesUserNickName(String likesUserNickName) {
        this.likesUserNickName = likesUserNickName;
    }
    public String getLikesUserHeadPortraitUrl() {
        return likesUserHeadPortraitUrl;
    }
    public void setLikesUserHeadPortraitUrl(String likesUserHeadPortraitUrl) {
        this.likesUserHeadPortraitUrl = likesUserHeadPortraitUrl;
    }
    public Date getLikesTime() {
        return likesTime;
    }
    public void setLikesTime(Date likesTime) {
        this.likesTime = likesTime;
    }
}