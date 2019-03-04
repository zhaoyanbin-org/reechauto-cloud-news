package com.reechauto.cloud.news.bean.req.news;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;


public class ShareModifyRequest extends BaseRequest {

	
	private static final long serialVersionUID = 1L;

	@NotNull(message = "用户ID不可以为NULL")
	private Long userId;
	
	@NotBlank(message = "动态唯一ID不可以为空")
	private String id;

	private String isTope;

	private String status;

	private String context;
	
	private String imagesUrl;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsTope() {
		return isTope;
	}

	public void setIsTope(String isTope) {
		this.isTope = isTope;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getImagesUrl() {
		return imagesUrl;
	}

	public void setImagesUrl(String imagesUrl) {
		this.imagesUrl = imagesUrl;
	}
	
	

}
