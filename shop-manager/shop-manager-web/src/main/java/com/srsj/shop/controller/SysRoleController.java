
package com.srsj.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.srsj.shop.bo.SysRoleRequest;
import com.srsj.common.bo.PageResponse;
import com.srsj.shop.model.SysRole;
import com.srsj.shop.service.SysRoleService;

 /**
  * desc : SysRole
  * Created by weichen on  2017/04/02.
  */

@Controller
@RequestMapping("/api/sysRole")
public class SysRoleController extends BaseController {

	@Autowired
	SysRoleService sysRoleService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	private String insert (SysRole record) {
		int r = sysRoleService.insert(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	private String delete (Long id) {
		int r = sysRoleService.delete(id);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	private String update (SysRole record) {
		int r = sysRoleService.update(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	private String list (SysRoleRequest clientRequest) {
		PageResponse<SysRole> r = sysRoleService.queryForPage(clientRequest);
		String str = callbackSuccess (r);
		return str;
	}

}