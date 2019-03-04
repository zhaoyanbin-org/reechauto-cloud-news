package com.reechauto.cloud.news.bean.req.comment;

import javax.validation.constraints.NotBlank;

import com.reechauto.cloud.news.bean.req.BaseRequest;


public class CommentDelRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "评论ID不可以为空")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
