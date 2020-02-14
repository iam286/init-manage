package com.y4l3.platform.module.sys.service;

import org.springframework.stereotype.Service;

import com.y4l3.platform.common.aop.annotation.Module;
import com.y4l3.platform.common.base.BaseService;
import com.y4l3.platform.module.sys.dao.DepartmentDao;
import com.y4l3.platform.module.sys.entity.Department;

/**
 * 部门 Service
 * @author changzhongq
 * @time 2018年6月17日 下午3:27:55
 */
@Service
@Module("部门管理")
public class DepartmentService extends BaseService<Department, DepartmentDao> {

}
