/*
 * 文 件 名:  SysLogServiceImpl.java
 * 创 建 人:  
 * 创建时间:  
 */

package com.srsj.shop.service.impl;

import org.springframework.stereotype.Service;

import com.srsj.shop.model.SysLog;
import com.srsj.shop.dao.SysLogDao;
import com.srsj.shop.service.SysLogService;
import com.srsj.common.service.impl.BaseServiceImpl;

 /**
  * desc : SysLog
  * Created by weichen on  2017/19/02.
  */
@Service
public class SysLogServiceImpl extends BaseServiceImpl<SysLogDao,SysLog> implements SysLogService {

}
