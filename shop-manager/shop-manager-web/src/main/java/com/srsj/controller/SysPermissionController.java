
package com.srsj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import com.srsj.bo.SysPermissionRequest;
import com.srsj.common.bo.PageResponse;
import com.srsj.model.SysPermission;
import com.srsj.service.SysPermissionService;

 /**
  * desc : SysPermission
  * Created by weichen on  2017/04/02.
  */

@Controller
@RequestMapping("/api/sysPermission")
public class SysPermissionController extends BaseController {

	@Autowired
	SysPermissionService sysPermissionService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	private String insert (SysPermission record) {
		int r = sysPermissionService.insert(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	private String delete (Long id) {
		int r = sysPermissionService.delete(id);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	private String update (SysPermission record) {
		int r = sysPermissionService.update(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	private String list (SysPermissionRequest clientRequest) {
		PageResponse<SysPermission> r = sysPermissionService.queryForPage(clientRequest);
		String str = callbackSuccess (r);
		return str;
	}

}