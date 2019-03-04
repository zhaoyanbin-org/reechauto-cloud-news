package com.reechauto.cloud.news.bean.req.comment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;


public class CommentAddRequest extends BaseRequest {
	
	
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "用户ID不可以为NULL")
	private Long userId;
	
	@NotBlank(message = "评论对象的ID不可以为空")
	private String newsShareId;

	private String commentContext;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	
}
