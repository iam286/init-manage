package com.y4l3.platform.module.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.y4l3.platform.common.base.BaseController;
import com.y4l3.platform.module.sys.entity.Department;
import com.y4l3.platform.module.sys.service.DepartmentService;

/**
 * 部门 Controller
 * @author changzhongq
 */
@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController<Department, DepartmentService> {

	private static final String PREFIX = "/module/sys/department/";

	@RequestMapping(value = "/departmentListPage", method = RequestMethod.GET)
	public String departmentListPage() {
		return PREFIX + "departmentList";
	}

	@RequestMapping(value = "/departmentForm", method = RequestMethod.GET)
	public String departmentForm() {
		return PREFIX + "departmentForm";
	}

	@RequestMapping(value = "/departmentTreePage", method = RequestMethod.GET)
	public String departmentTreePage() {
		return PREFIX + "departmentTree";
	}
	
}
