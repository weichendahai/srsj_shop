package com.srsj.controller;

import com.srsj.pojo.SysRole;
import com.srsj.service.ISysRoleService;
import com.srsj.common.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by weichen on 2017/5/25.
 */

@Controller
@RequestMapping("/api/role")
public class SysRoleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    ISysRoleService sysRoleService;

    @RequestMapping("/list")
    @ResponseBody
    private String roleList () {

        List<SysRole> listRole = sysRoleService.queryAll();
        String rolesStr = JsonUtils.objectToJson(listRole);
        return rolesStr;
    }


//    @RequestMapping("/list")
//    @ResponseBody
//    private String roleList () {
//
//        List<SysRole> listRole = sysRoleService.selectAllList();
//        String rolesStr = JsonUtils.objectToJson(listRole);
//        return rolesStr;
//    }
//
//    @RequestMapping(value = "/insert", method = RequestMethod.POST)
//    @ResponseBody
//    private String insert (SysRole record) {
//        int r = sysRoleService.insert(record);
//        String rolesStr = JsonUtils.objectToJson(r);
//        return rolesStr;
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @ResponseBody
//    private String update (SysRole record) {
//        int r = sysRoleService.updateByPrimaryKey(record);
//        String rolesStr = JsonUtils.objectToJson(r);
//        return rolesStr;
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    @ResponseBody
//    private String delete (Long roleId) {
//        int r = sysRoleService.deleteByPrimaryKey(roleId);
//        String rolesStr = JsonUtils.objectToJson(r);
//        return rolesStr;
//    }
}