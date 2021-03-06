
package com.srsj.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.srsj.shop.bo.SysLogRequest;
import com.srsj.common.bo.PageResponse;
import com.srsj.shop.model.SysLog;
import com.srsj.shop.service.SysLogService;

 /**
  * desc : SysLog
  * Created by weichen on  2017/04/02.
  */

@Controller
@RequestMapping("/api/sysLog")
public class SysLogController extends BaseController {

	@Autowired
	SysLogService sysLogService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	private String insert (SysLog record) {
		int r = sysLogService.insert(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	private String delete (Long id) {
		int r = sysLogService.delete(id);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	private String update (SysLog record) {
		int r = sysLogService.update(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	private String list (SysLogRequest clientRequest) {
		PageResponse<SysLog> r = sysLogService.queryForPage(clientRequest);
		String str = callbackSuccess (r);
		return str;
	}

}