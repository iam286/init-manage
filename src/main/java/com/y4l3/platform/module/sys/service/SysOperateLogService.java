package com.y4l3.platform.module.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.y4l3.platform.common.aop.annotation.NoRecordLog;
import com.y4l3.platform.common.base.BaseService;
import com.y4l3.platform.module.sys.dao.SysOperateLogDao;
import com.y4l3.platform.module.sys.entity.SysOperateLog;

/**
 * 操作日志 Service
 * @author changzhongq
 * @time 2018年8月7日 下午3:26:02
 */
@Service
@NoRecordLog
public class SysOperateLogService extends BaseService<SysOperateLog, SysOperateLogDao> {

	public List<SysOperateLog> findSysOperateLogList(Map<String, Object> paramMap) {
		return mapper.findSysOperateLogList(paramMap);
	}

	/**
	 * 根据操作类型统计日志
	 * @return
	 */
	public List<Map<String, Object>> statisticsByOperateType() {
		return mapper.statisticsByOperateType();
	}
	
	/**
	 * 根据用户统计访问树
	 * @return
	 */
	public List<Map<String, Object>> statisticsByUser() {
		return mapper.statisticsByUser();
	}
}
