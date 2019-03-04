package com.reechauto.cloud.news.bean.req.news;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.reechauto.cloud.news.bean.req.BaseRequest;


public class NewsQueryRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "用户ID不可以为NULL")
	private Long userId;
	
//	@ApiModelProperty(value = "状态(Y:正常,N:删除)", dataType = "String")
	private String status;

//	@ApiModelProperty(value = "发布人", dataType = "Long")
	private Long pushUserId;

//	@ApiModelProperty(value = "发布时间", dataType = "String")
	@Pattern(regexp = "(^$)|(^((?:19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$)", message = "日期格式为yyyy-MM-dd")
	private String createDate;

//	@ApiModelProperty(value = "是否置顶(N:普通,Y:置顶)", dataType = "String")
	private String isTope;

//	@ApiModelProperty(value = "按标题检索条件", dataType = "String")
	private String searchCondition;

//	@ApiModelProperty(value = "显示条数", dataType = "int", required = true)
	@Min(value = 1, message = "显示条数不能小于1")
	private int pageNum = 10;

//	@ApiModelProperty(value = "开始位置", dataType = "int", required = true)
	@Min(value = 0, message = "开始位置不能小于0")
	private int start = 0;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getPushUserId() {
		return pushUserId;
	}

	public void setPushUserId(Long pushUserId) {
		this.pushUserId = pushUserId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getIsTope() {
		return isTope;
	}

	public void setIsTope(String isTope) {
		this.isTope = isTope;
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
	
}
