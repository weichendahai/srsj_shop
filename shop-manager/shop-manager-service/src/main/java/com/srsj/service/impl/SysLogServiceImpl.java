/*
 * 文 件 名:  SysLogServiceImpl.java
 * 创 建 人:  
 * 创建时间:  
 */

package com.srsj.service.impl;

import org.springframework.stereotype.Service;

import com.srsj.model.SysLog;
import com.srsj.dao.SysLogDao;
import com.srsj.service.SysLogService;
import com.srsj.common.service.impl.BaseServiceImpl;

 /**
  * desc : SysLog
  * Created by weichen on  2017/19/02.
  */
@Service
public class SysLogServiceImpl extends BaseServiceImpl<SysLogDao,SysLog> implements SysLogService {

}
