package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotNull;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class MenuDelRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	@NotNull(message = "id不可以为null")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
