/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2017
 */

package com.srsj.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SysUser
 * @version 1.0
 * @author
 */
public class SysUser implements Serializable {

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
	// 创建时间
	private Date createTime;
	// 最后登录时间
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
