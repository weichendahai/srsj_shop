
package com.srsj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import com.srsj.bo.SysRolePermissionRequest;
import com.srsj.common.bo.PageResponse;
import com.srsj.model.SysRolePermission;
import com.srsj.service.SysRolePermissionService;

 /**
  * desc : SysRolePermission
  * Created by weichen on  2017/04/02.
  */

@Controller
@RequestMapping("/api/sysRolePermission")
public class SysRolePermissionController extends BaseController {

	@Autowired
	SysRolePermissionService sysRolePermissionService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	private String insert (SysRolePermission record) {
		int r = sysRolePermissionService.insert(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	private String delete (Long id) {
		int r = sysRolePermissionService.delete(id);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	private String update (SysRolePermission record) {
		int r = sysRolePermissionService.update(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	private String list (SysRolePermissionRequest clientRequest) {
		PageResponse<SysRolePermission> r = sysRolePermissionService.queryForPage(clientRequest);
		String str = callbackSuccess (r);
		return str;
	}

}