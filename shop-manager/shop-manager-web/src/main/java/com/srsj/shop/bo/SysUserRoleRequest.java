package com.srsj.shop.bo;

import com.srsj.common.bo.PageRequest;

/**
  * desc : SysUserRole
  * Created by weichen on  2017/55/02.
  */

public class SysUserRoleRequest extends PageRequest {

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
