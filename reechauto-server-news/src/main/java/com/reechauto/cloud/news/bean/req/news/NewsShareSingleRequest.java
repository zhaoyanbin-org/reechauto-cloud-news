package com.reechauto.cloud.news.bean.req.news;

import javax.validation.constraints.NotBlank;

import com.reechauto.cloud.news.bean.req.BaseRequest;


public class NewsShareSingleRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "唯一ID不可以为空")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
