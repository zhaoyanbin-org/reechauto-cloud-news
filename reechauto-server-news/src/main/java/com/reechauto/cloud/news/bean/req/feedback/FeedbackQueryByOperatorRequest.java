package com.reechauto.cloud.news.bean.req.feedback;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.reechauto.cloud.news.bean.req.BaseRequest;


public class FeedbackQueryByOperatorRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	
	@Pattern(regexp = "^1[345678][0-9]{9}$", message = "手机格式不正确")
	private String mobileNum;
	
	@NotNull(message = "操作员ID不可以为NULL")
	private Long operatorId;
	
	
	private String status;
	
	@Pattern(regexp = "(^$)|(^((?:19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$)", message = "日期格式为yyyy-MM-dd")
	private String beginDate;
	
	@Pattern(regexp = "(^$)|(^((?:19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$)", message = "日期格式为yyyy-MM-dd")
	private String endDate;
	
	@Min(value = 1, message = "显示条数不能小于1")
	private int pageNum = 10;

	@Min(value = 0, message = "开始位置不能小于0")
	private int start = 0;

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
