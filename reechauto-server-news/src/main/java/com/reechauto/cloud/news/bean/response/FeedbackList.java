package com.reechauto.cloud.news.bean.response;

import java.io.Serializable;
import java.util.Date;

public class FeedbackList implements Serializable {
	
	 private Integer id;
	    /**
	     * 用户提的问题
	     */
	    private String question;
	    /**
	     * 回复内容
	     */
	    private String answer;
	    /**
	     * 问题提交的时间
	     */
	    private Date questionTime;
	    /**
	     * 回复时间
	     */
	    private Date answerTime;
	    /**
	     * 是否已经回复,‘Y’为已回复，'N'为未回复
	     */
	    private String status;
	    /**
	     * 提问者的id号
	     */
	    private Long questionerId;
	    /**
	     * 回复者的id号
	     */
	    private Long answererId;
	    
	    /**
	     *提问者手机号
	     */
	    private String mobileNum;
	    
	    private static final long serialVersionUID = 1L;

	    public Integer getId() {
	        return id;
	    }
	    public void setId(Integer id) {
	        this.id = id;
	    }
	    public String getQuestion() {
	        return question;
	    }
	    public void setQuestion(String question) {
	        this.question = question;
	    }
	    public String getAnswer() {
	        return answer;
	    }
	    public void setAnswer(String answer) {
	        this.answer = answer;
	    }
	    public Date getQuestionTime() {
	        return questionTime;
	    }
	    public void setQuestionTime(Date questionTime) {
	        this.questionTime = questionTime;
	    }
	    public Date getAnswerTime() {
	        return answerTime;
	    }
	    public void setAnswerTime(Date answerTime) {
	        this.answerTime = answerTime;
	    }
	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }
	    public Long getQuestionerId() {
	        return questionerId;
	    }
	    public void setQuestionerId(Long questionerId) {
	        this.questionerId = questionerId;
	    }
	    public Long getAnswererId() {
	        return answererId;
	    }
	    public void setAnswererId(Long answererId) {
	        this.answererId = answererId;
	    }
		public String getMobileNum() {
			return mobileNum;
		}
		public void setMobileNum(String mobileNum) {
			this.mobileNum = mobileNum;
		}
	    
	    
}
