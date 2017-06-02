/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2017
 */

package com.srsj.model;

import java.io.Serializable;
import java.util.Date;

/**
 * SysRolePermission
 * @version 1.0
 * @author
 */
public class SysRolePermission implements Serializable {

	// 主键
	private Long id;
	// 角色ID
	private Long rid;
	// 权限ID
	private Long pid;
		
	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setRid(Long value) {
		this.rid = value;
	}
	
	public Long getRid() {
		return this.rid;
	}
	
	public void setPid(Long value) {
		this.pid = value;
	}
	
	public Long getPid() {
		return this.pid;
	}
	
}
