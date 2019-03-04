package com.reechauto.cloud.news.bean.req.feedback;

import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;


public class FeedbackAnswerByOperatorRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "操作员ID不可以为NULL")
	private Long operatorId;
	
	@NotNull(message = "意见反馈ID不可以为NULL")
	private int appFeedbackId;
	
	@NotNull(message = "意见反馈内容不可以为NULL")
	private String content;

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public int getAppFeedbackId() {
		return appFeedbackId;
	}

	public void setAppFeedbackId(int appFeedbackId) {
		this.appFeedbackId = appFeedbackId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
}
