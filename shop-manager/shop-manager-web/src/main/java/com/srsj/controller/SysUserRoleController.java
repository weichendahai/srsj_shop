
package com.srsj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import com.srsj.bo.SysUserRoleRequest;
import com.srsj.common.bo.PageResponse;
import com.srsj.model.SysUserRole;
import com.srsj.service.SysUserRoleService;

 /**
  * desc : SysUserRole
  * Created by weichen on  2017/04/02.
  */

@Controller
@RequestMapping("/api/sysUserRole")
public class SysUserRoleController extends BaseController {

	@Autowired
	SysUserRoleService sysUserRoleService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	private String insert (SysUserRole record) {
		int r = sysUserRoleService.insert(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	private String delete (Long id) {
		int r = sysUserRoleService.delete(id);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	private String update (SysUserRole record) {
		int r = sysUserRoleService.update(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	private String list (SysUserRoleRequest clientRequest) {
		PageResponse<SysUserRole> r = sysUserRoleService.queryForPage(clientRequest);
		String str = callbackSuccess (r);
		return str;
	}

}