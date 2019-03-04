package com.reechauto.cloud.news.bean.req.notice;

import javax.validation.constraints.NotBlank;

import com.reechauto.cloud.news.bean.req.BaseRequest;


public class NoticeReadRequest extends BaseRequest {
	
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "消息ID不可以为空")
	private String noticeId;

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	
}
