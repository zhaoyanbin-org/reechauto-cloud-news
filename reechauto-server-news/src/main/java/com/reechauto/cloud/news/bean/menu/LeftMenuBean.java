package com.reechauto.cloud.news.bean.menu;

import java.io.Serializable;
import java.util.List;

public class LeftMenuBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	/**
	 * 菜单编码
	 */
	private String code;
	/**
	 * 父菜单ID
	 */
	private Long pId;
	/**
	 * 菜单父编码
	 */
	private String pCode;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 请求地址
	 */
	private String url;
	/**
	 * 1.菜单，2.按钮，3.权限
	 */
	private Integer type;
	/**
	 * 菜单层级
	 */
	private Integer level;
	/**
	 * 菜单排序
	 */
	private Integer sort;
	/**
	 * Y/N
	 */
	private String status;
	private String icon;

	private List<LeftMenuBean> child;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<LeftMenuBean> getChild() {
		return child;
	}

	public void setChild(List<LeftMenuBean> child) {
		this.child = child;
	}

}
