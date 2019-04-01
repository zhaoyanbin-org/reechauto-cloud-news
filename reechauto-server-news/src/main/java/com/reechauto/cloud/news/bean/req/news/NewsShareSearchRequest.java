package com.reechauto.cloud.news.bean.req.news;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class NewsShareSearchRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "用户ID不可以为NULL")
	private Long userId;
	
	private String context="";
	
	@Min(value = 0, message = "开始位置不能小于0")
	private Integer start = 0;
	
	@Min(value = 1, message = "显示条数不能小于1")
	private int pageNum = 10;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
}
