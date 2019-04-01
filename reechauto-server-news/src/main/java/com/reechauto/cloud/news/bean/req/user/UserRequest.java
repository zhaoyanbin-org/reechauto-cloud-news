package com.reechauto.cloud.news.bean.req.user;

import javax.validation.constraints.Min;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class UserRequest extends BaseRequest{

	private static final long serialVersionUID = 1L;

	private Long userId;

	@Min(value = 1, message = "显示条数不能小于1")
	private Integer pageNum = 10;

	@Min(value = 0, message = "开始位置不能小于0")
	private Integer start = 0;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}
}
