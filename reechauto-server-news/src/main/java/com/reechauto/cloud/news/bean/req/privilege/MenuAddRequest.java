package com.reechauto.cloud.news.bean.req.privilege;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class MenuAddRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "pId不可以为null")
	private int pId;
	@NotBlank(message = "pCode不可以为空")
	private String pCode;
	@NotBlank(message = "name不可以为空")
	private String name;
	private String url;
	@NotNull(message = "type不可以为null,1:菜单，2：按钮，3：权限")
	private int type;
	private int sort = 0;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
}
