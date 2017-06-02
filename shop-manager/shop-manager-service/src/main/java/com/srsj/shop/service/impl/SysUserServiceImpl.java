/*
 * 文 件 名:  SysUserServiceImpl.java
 * 创 建 人:  
 * 创建时间:  
 */

package com.srsj.shop.service.impl;

import org.springframework.stereotype.Service;

import com.srsj.shop.model.SysUser;
import com.srsj.shop.dao.SysUserDao;
import com.srsj.shop.service.SysUserService;
import com.srsj.common.service.impl.BaseServiceImpl;

 /**
  * desc : SysUser
  * Created by weichen on  2017/19/02.
  */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao,SysUser> implements SysUserService {

}
