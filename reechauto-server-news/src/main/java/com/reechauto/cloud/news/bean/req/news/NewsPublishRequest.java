package com.reechauto.cloud.news.bean.req.news;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class NewsPublishRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "用户ID不可以为NULL")
	private Long userId;

	@NotBlank(message = "资讯标题不可以为空")
	private String title;
	/**
	 * 简介
	 */
	@NotBlank(message = "简介不可以为空")
	private String intro;
	/**
	 * 内容
	 */
	@NotBlank(message = "内容不可以为空")
	private String context;
	/**
	 * 逗号分割
	 */
	private String imagesUrl;
	/**
	 * N:普通,Y:置顶
	 */
	private String isTope;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
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

	public String getIsTope() {
		return isTope;
	}

	public void setIsTope(String isTope) {
		this.isTope = isTope;
	}

}
