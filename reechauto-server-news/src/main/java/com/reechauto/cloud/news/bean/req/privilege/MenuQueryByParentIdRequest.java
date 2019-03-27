package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotNull;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class MenuQueryByParentIdRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	@NotNull(message = "pId不可以为null")
	private Long pId;
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}

}
