package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class MenusQueryRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "用户ID不可以为NULL")
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
