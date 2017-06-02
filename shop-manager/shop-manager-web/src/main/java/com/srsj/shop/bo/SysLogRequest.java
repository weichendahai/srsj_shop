package com.srsj.shop.bo;

import com.srsj.common.bo.PageRequest;
import java.util.Date;

 /**
  * desc : SysLog
  * Created by weichen on  2017/55/02.
  */

public class SysLogRequest extends PageRequest {

	// 主键
	private Long id;
	// 用户ID
	private Long uid;
	// 日志内容
	private String content;
	// 用户操作
	private String operation;
	// 创建时间
	private Date createTime;
		
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
	
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setOperation(String value) {
		this.operation = value;
	}
	
	public String getOperation() {
		return this.operation;
	}
	
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
}
