package com.y4l3.platform.module.sys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.y4l3.platform.common.base.BaseController;
import com.y4l3.platform.common.message.PageRequest;
import com.y4l3.platform.common.message.PageResult;
import com.y4l3.platform.common.message.PageResultHelper;
import com.y4l3.platform.common.message.ResponseResult;
import com.y4l3.platform.common.utils.HttpServletUtils;
import com.y4l3.platform.module.sys.entity.SysOperateLog;
import com.y4l3.platform.module.sys.service.SysOperateLogService;

/**
 * 操作日志 Controller
 * @author changzhongq
 */
@Controller
@RequestMapping("/sysOperateLog")
public class SysOperateLogController extends BaseController<SysOperateLog, SysOperateLogService> {

	private static final String PATH_PREFIX = "/module/sys/sysOperateLog/";

	@RequestMapping(value = "/sysOperateLogListPage", method = RequestMethod.GET)
	public String sysOperateLogListPage() {
		return PATH_PREFIX + "sysOperateLogList";
	}

	@RequestMapping(value = "/sysOperateLogForm", method = RequestMethod.GET)
	public String sysOperateLogForm() {
		return PATH_PREFIX + "sysOperateLogForm";
	}

	@RequestMapping(value = "/sysOperateLogList", method = RequestMethod.GET)
	@ResponseBody
	public PageResult sysOperateLogList(HttpServletRequest request, PageRequest pageRequest) {

		Map<String, Object> paramMap = HttpServletUtils.parseRequestByParam(request);
		PageResultHelper.startPage(pageRequest);
		return PageResultHelper.parseResult(service.findSysOperateLogList(paramMap));
	}

	/**
	 * 根据操作类型统计日志
	 * @return
	 */
	@RequestMapping(value = "/statisticsOperateLog", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult statisticsByOperateType() {
		return ResponseResult.ok(service.statisticsByOperateType());
	}

	/**
	 * 根据用户统计访问数量
	 * @return
	 */
	@RequestMapping(value = "/statisticsVisitUser", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult statisticsByUser() {
		return ResponseResult.ok(service.statisticsByUser());
	}
}
