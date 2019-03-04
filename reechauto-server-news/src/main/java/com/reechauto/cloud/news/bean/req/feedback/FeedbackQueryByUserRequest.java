package com.reechauto.cloud.news.bean.req.feedback;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;

public class FeedbackQueryByUserRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "用户ID不可以为NULL")
	private Long userId;

	@Min(value = 1, message = "显示条数不能小于1")
	private int pageNum = 10;

	@Min(value = 0, message = "开始位置不能小于0")
	private int start = 0;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

}
