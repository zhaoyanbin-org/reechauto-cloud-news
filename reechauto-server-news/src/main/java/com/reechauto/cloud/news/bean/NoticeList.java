package com.reechauto.cloud.news.bean;

import java.util.Date;

import com.reechauto.cloud.news.entity.NewsShareComment;
import com.reechauto.cloud.news.entity.NewsShareLikes;
import com.reechauto.cloud.news.entity.NewsShareWithBLOBs;



public class NoticeList {
	private String id;
	private Long notifyId;
	private String newsShareId;
	private String relationId;
	private String noticeType;
	private String isRead;
	private Date readTime;

	private NewsShareWithBLOBs newsShare;
	private NewsShareComment comment;
	private NewsShareLikes newsShareLikes;

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

	public NewsShareWithBLOBs getNewsShare() {
		return newsShare;
	}

	public void setNewsShare(NewsShareWithBLOBs newsShare) {
		this.newsShare = newsShare;
	}

	public NewsShareComment getComment() {
		return comment;
	}

	public void setComment(NewsShareComment comment) {
		this.comment = comment;
	}

	public NewsShareLikes getNewsShareLikes() {
		return newsShareLikes;
	}

	public void setNewsShareLikes(NewsShareLikes newsShareLikes) {
		this.newsShareLikes = newsShareLikes;
	}

}
