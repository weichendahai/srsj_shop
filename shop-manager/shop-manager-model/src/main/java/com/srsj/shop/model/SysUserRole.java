/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2017
 */

package com.srsj.shop.model;

import java.io.Serializable;

/**
 * SysUserRole
 * @version 1.0
 * @author
 */
public class SysUserRole implements Serializable {

	// 主键
	private Long id;
	// 用户ID
	private Long uid;
	// 角色ID
	private Long rid;
		
	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setUid(Long value) {
		this.uid = value;
	}
	
	public Long getUid() {
		return this.uid;
	}
	
	public void setRid(Long value) {
		this.rid = value;
	}
	
	public Long getRid() {
		return this.rid;
	}
	
}
