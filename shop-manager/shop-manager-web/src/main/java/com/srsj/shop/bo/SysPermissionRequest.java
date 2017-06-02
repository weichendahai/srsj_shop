package com.srsj.shop.bo;

import com.srsj.common.bo.PageRequest;

/**
  * desc : SysPermission
  * Created by weichen on  2017/55/02.
  */

public class SysPermissionRequest extends PageRequest {

	// 主键
	private Long id;
	// 上级ID
	private Long pid;
	// 标题
	private String title;
	// 类型 0、菜单 1、功能
	private Integer type;
	// 状态 0、正常 1、禁用
	private Integer state;
	// 排序
	private Integer sort;
	// 地址
	private String url;
	// 权限编码
	private String permCode;
	// 图标
	private String icon;
	// 描述
	private String description;
		
	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setPid(Long value) {
		this.pid = value;
	}
	
	public Long getPid() {
		return this.pid;
	}
	
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return this.type;
	}
	
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	
	public void setSort(Integer value) {
		this.sort = value;
	}
	
	public Integer getSort() {
		return this.sort;
	}
	
	public void setUrl(String value) {
		this.url = value;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setPermCode(String value) {
		this.permCode = value;
	}
	
	public String getPermCode() {
		return this.permCode;
	}
	
	public void setIcon(String value) {
		this.icon = value;
	}
	
	public String getIcon() {
		return this.icon;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return this.description;
	}
	
}
