package com.reechauto.cloud.news.bean.req.news;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.enums.NewsShareStatusEnum;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class ShareQueryRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "用户ID不可以为NULL")
	private Long userId;

	private String searchCondition;

	@Min(value = 1, message = "显示条数不能小于1")
	private int pageNum = 10;

	@Min(value = 0, message = "开始位置不能小于0")
	private int start = 0;

	private String status = NewsShareStatusEnum.Y.getValue();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
