package com.srsj.controller;

import com.srsj.pojo.SysUser;
import com.srsj.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by weichen on 2017/5/25.
 */

@Controller
@RequestMapping("/api/user")
public class SysUserController extends BaseController {

    @Autowired
    ISysUserService sysUserService;

    @RequestMapping("/list")
    @ResponseBody
    private String userList () {
        List<SysUser> list = sysUserService.queryAll();
        String usersStr = callbackSuccess(list);
        LOGGER.info(usersStr);
        return usersStr;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    private String add (SysUser record) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        record.setCreateTime( df.format(new Date()) );
        record.setLastTime( df.format(new Date()) );

        int r = sysUserService.add(record);
        String userStr = toJson(r);
        return userStr;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    private String update (SysUser record) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        record.setLastTime( df.format(new Date()) );

        int r = sysUserService.update(record);
        String userStr = toJson(r);
        return userStr;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    private String delete (Long userId) {
        int r = sysUserService.delete(userId);
        String userStr = toJson(r);
        return userStr;
    }
}


//package com.srsj.controller;
//
//import com.srsj.pojo.SysUser;
//import com.srsj.service.ISysUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by weichen on 2017/5/25.
// */
//
//@Controller
//@RequestMapping("/api/user")
//public class SysUserController extends BaseController {
//
//    @Autowired
//    ISysUserService sysUserService;
//
//    @RequestMapping("/list")
//    @ResponseBody
//    private String userList () {
//        List<SysUser> list = sysUserService.queryAll(null);
//        String usersStr = callbackSuccess(list);
//        LOGGER.info(usersStr);
//        return usersStr;
//    }
//
//    @RequestMapping("/info/{userId}")
//    @ResponseBody
//    private String getUser (@PathVariable Long userId) {
//        SysUser user = sysUserService.queryById(userId);
//        String userStr = toJson(user);
//        return userStr;
//    }
//
//    //====== 适配前端 url
//    @RequestMapping("/info")
//    @ResponseBody
////    http://localhost:8080/user/info?token=admin
//    private String getUserInfo (String token) {
//        SysUser user = sysUserService.queryById((long)2);
//        String userStr = toJson(user);
//        return userStr;
//    }
//
//    @RequestMapping(value = "/insert", method = RequestMethod.POST)
//    @ResponseBody
//    private String add (SysUser record) {
//
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        record.setCreateTime( df.format(new Date()) );
//        record.setLastTime( df.format(new Date()) );
//
//        int r = sysUserService.add(record);
//        String userStr = toJson(r);
//        return userStr;
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @ResponseBody
//    private String update (SysUser record) {
//
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        record.setLastTime( df.format(new Date()) );
//
//        int r = sysUserService.update(record);
//        String userStr = toJson(r);
//        return userStr;
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    @ResponseBody
//    private String delete (Long userId) {
//        int r = sysUserService.delete(userId);
//        String userStr = toJson(r);
//        return userStr;
//    }
//}