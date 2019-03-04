package com.reechauto.cloud.news.bean.req.news;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class NewsModifyRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "用户ID不可以为NULL")
	private Long userId;

	@NotBlank(message = "资讯唯一ID不可以为空")
	private String id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 简介
	 */
	private String intro;
	/**
	 * 内容
	 */
	private String context;
	/**
	 * 逗号分割
	 */
	private String imagesUrl;
	/**
	 * N：普通，Y:置顶
	 */
	private String isTope;

	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
