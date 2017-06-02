/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2017
 */

package com.srsj.shop.model;

import java.io.Serializable;

/**
 * SysRole
 * @version 1.0
 * @author
 */
public class SysRole implements Serializable {

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
