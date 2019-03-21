package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotNull;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class MenuQueryByParentIdRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	@NotNull(message = "pId不可以为null")
	private int pId;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}
	
}
