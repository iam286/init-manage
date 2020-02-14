package com.y4l3.platform.module.sys.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 部门 实体
 * @author changzhongq
 * @time 2018年6月17日 下午3:25:43
 */
@Data
@Table(name = "sys_department")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String departmentId;
	
	private String departmentName;
	
	private String parentId;
	
	private String parentName;
	
	private String remark;
}
