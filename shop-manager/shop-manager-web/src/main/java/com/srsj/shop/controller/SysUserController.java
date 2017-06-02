
package com.srsj.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.srsj.shop.bo.SysUserRequest;
import com.srsj.common.bo.PageResponse;
import com.srsj.shop.model.SysUser;
import com.srsj.shop.service.SysUserService;

 /**
  * desc : SysUser
  * Created by weichen on  2017/04/02.
  */

@Controller
@RequestMapping("/api/sysUser")
public class SysUserController extends BaseController {

	@Autowired
	SysUserService sysUserService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	private String insert (SysUser record) {
		int r = sysUserService.insert(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	private String delete (Long id) {
		int r = sysUserService.delete(id);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	private String update (SysUser record) {
		int r = sysUserService.update(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	private String list (SysUserRequest clientRequest) {
		PageResponse<SysUser> r = sysUserService.queryForPage(clientRequest);
		String str = callbackSuccess (r);
		return str;
	}

}