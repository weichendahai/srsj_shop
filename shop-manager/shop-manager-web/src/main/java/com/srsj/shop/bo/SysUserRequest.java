package com.srsj.shop.bo;

import com.srsj.common.bo.PageRequest;
import java.util.Date;

 /**
  * desc : SysUser
  * Created by weichen on  2017/55/02.
  */

public class SysUserRequest extends PageRequest {

	// 主键ID
	private Long id;
	// 登录名称
	private String loginName;
	// 密码
	private String password;
	// 邮箱
	private String email;
	// 0、普通用户 1、管理员
	private Integer type;
	// 0、禁用 1、正常
	private Integer status;
	// createTime
	private Date createTime;
	// lastTime
	private Date lastTime;
		
	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setLoginName(String value) {
		this.loginName = value;
	}
	
	public String getLoginName() {
		return this.loginName;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return this.type;
	}
	
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setLastTime(Date value) {
		this.lastTime = value;
	}
	
	public Date getLastTime() {
		return this.lastTime;
	}
	
}
