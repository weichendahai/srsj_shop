package com.srsj.shop.bo;

import com.srsj.common.bo.PageRequest;

/**
  * desc : SysRole
  * Created by weichen on  2017/55/02.
  */

public class SysRoleRequest extends PageRequest {

	// 主键
	private Long id;
	// 角色
	private String name;
	// 排序
	private Integer sort;
	// 描述
	private String description;
		
	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSort(Integer value) {
		this.sort = value;
	}
	
	public Integer getSort() {
		return this.sort;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return this.description;
	}
	
}
