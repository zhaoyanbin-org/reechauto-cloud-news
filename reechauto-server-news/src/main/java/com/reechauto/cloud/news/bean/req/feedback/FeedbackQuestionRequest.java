package com.reechauto.cloud.news.bean.req.feedback;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.reechauto.cloud.news.bean.req.BaseRequest;


public class FeedbackQuestionRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "问题不可以为空")
	private String question;
	
	@NotNull(message = "用户ID不可以为NULL")
	private Long userId;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
