package com.reechauto.cloud.news.bean.req.comment;

import javax.validation.constraints.NotBlank;

import com.reechauto.cloud.news.bean.req.BaseRequest;


public class CommentQueryRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "评论对象的ID不可以为空")
	private String newsShareId;

	public String getNewsShareId() {
		return newsShareId;
	}

	public void setNewsShareId(String newsShareId) {
		this.newsShareId = newsShareId;
	}
	
	
}
