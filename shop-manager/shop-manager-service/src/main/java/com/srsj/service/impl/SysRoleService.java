package com.srsj.service.impl;

import com.srsj.common.service.impl.BaseServiceImpl;
import com.srsj.dao.SysRoleMapper;
import com.srsj.pojo.SysRole;
import com.srsj.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weichen on 2017/5/25.
 */

//@Service
//public class SysRoleService implements ISysRoleService {
//    @Autowired
//    protected  SysRoleMapper sysRoleMapper;
//
//    public List<SysRole> queryAll () {
//        return sysRoleMapper.queryAll();
//    }
//}

//public class UserWalletService extends BaseServiceImpl<UserWallet> {
//@Service
//public class SysRoleService extends BaseServiceImpl<SysRole> {
//

@Service
public class SysRoleService extends BaseServiceImpl<SysRoleMapper,SysRole> implements ISysRoleService {

}



