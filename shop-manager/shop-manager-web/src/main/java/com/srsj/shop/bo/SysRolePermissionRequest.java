package com.srsj.shop.bo;

import com.srsj.common.bo.PageRequest;

/**
  * desc : SysRolePermission
  * Created by weichen on  2017/55/02.
  */

public class SysRolePermissionRequest extends PageRequest {

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
