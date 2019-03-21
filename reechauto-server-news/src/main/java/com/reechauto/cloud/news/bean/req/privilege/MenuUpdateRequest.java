package com.reechauto.cloud.news.bean.req.privilege;

import javax.validation.constraints.NotNull;
import com.reechauto.cloud.news.bean.req.BaseRequest;

public class MenuUpdateRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;
	@NotNull(message = "id不可以为null")
	private int id;
	private String name;
	private String url;
	private Integer isMenu;
	private Integer sort = 0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Integer getIsMenu() {
		return isMenu;
	}
	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
}