package com.reechauto.cloud.news.bean.req.comment;

import javax.validation.constraints.NotBlank;

import com.reechauto.cloud.news.bean.req.BaseRequest;


public class CommentModifyRequest extends BaseRequest {

	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "评论ID不可以为空")
	private String id;

	private String commentContext;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCommentContext() {
		return commentContext;
	}

	public void setCommentContext(String commentContext) {
		this.commentContext = commentContext;
	}
	
}
