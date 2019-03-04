package com.reechauto.cloud.news.bean.req.news;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;


public class NewsShareLikesRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "用户ID不可以为NULL")
	private Long userId;
	
	//@ApiModelProperty(value = "资讯唯一ID", dataType = "String", required = true)
	@NotBlank(message = "资讯唯一ID不可以为空")
	private String newsShareId;

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
	
	
}
