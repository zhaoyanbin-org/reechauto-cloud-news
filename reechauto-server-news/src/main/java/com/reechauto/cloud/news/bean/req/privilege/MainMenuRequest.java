package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class MainMenuRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "当前登录用户Id不可以为null")
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
