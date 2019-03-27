package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotNull;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class MenuDelRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	@NotNull(message = "id不可以为null")
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
