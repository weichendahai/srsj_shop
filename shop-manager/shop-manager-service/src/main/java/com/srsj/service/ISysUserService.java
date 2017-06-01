package com.srsj.service;

//import com.srsj.common.service.IBaseService;
import com.srsj.common.service.IBaseService;
import com.srsj.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weichen on 2017/5/25.
 */

public interface ISysUserService extends IBaseService<SysUser> {

}

//public interface ISysUserService  {
//    List<SysUser> queryAll ();
//}