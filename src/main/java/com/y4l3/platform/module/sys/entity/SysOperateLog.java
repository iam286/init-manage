package com.y4l3.platform.module.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 操作日志 实体类
 * @author changzhongq
 * @time 2018年6月22日 下午6:08:08
 */
@Data
@Table(name = "sys_operate_log")
public class SysOperateLog implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 日志ID
	 */
	@Id
	private String logId;

	/**
	 * 操作类型（-1：退出系统，1：进入系统，2：查询，3：新增，4：修改，5：删除） 需要其他类型，请自添加并注释
	 */
	private String operateType;

	/**
	 * 操作系统名称
	 */
	private String operateSystem;

	/**
	 * 操作模块
	 */
	private String operateModule;

	/**
	 * 操作人ID
	 */
	private String operateUserId;

	/**
	 * 操作人名称
	 */
	private String operateUserName;

	/**
	 * 操作时间
	 */
	private Date operateTime;

	/**
	 * 更新参数
	 */
	private String updateParams;

	/**
	 * 请求路径
	 */
	private String requestUrl;

	/**
	 * 表名
	 */
	private String tableName;

	/**
	 * IP地址
	 */
	private String ip;

	/**
	 * 操作状态（0：失败，1：成功）
	 */
	private int operateStatus;

	@Override
	public String toString() {
		return "SysOperateLog [logId=" + logId + ", operateType=" + operateType + ", operateSystem=" + operateSystem + ", operateModule=" + operateModule + ", operateUserId=" + operateUserId
				+ ", operateUserName=" + operateUserName + ", operateTime=" + operateTime + ", updateParams=" + updateParams + ", requestUrl=" + requestUrl + ", tableName=" + tableName + ", ip=" + ip
				+ "]";
	}
}
