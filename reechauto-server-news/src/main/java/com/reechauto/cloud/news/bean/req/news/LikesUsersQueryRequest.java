package com.reechauto.cloud.news.bean.req.news;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.reechauto.cloud.news.bean.req.BaseRequest;


public class LikesUsersQueryRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "资讯动态唯一ID不可以为空")
	private String newsShareId;

	@Min(value = 1, message = "显示条数不能小于1")
	private int pageNum = 10;

	@Min(value = 0, message = "开始位置不能小于0")
	private int start = 0;

	public String getNewsShareId() {
		return newsShareId;
	}

	public void setNewsShareId(String newsShareId) {
		this.newsShareId = newsShareId;
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


	
}
