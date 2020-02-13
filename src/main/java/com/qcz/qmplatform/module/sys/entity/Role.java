package com.qcz.qmplatform.module.sys.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色 实体
 * @author changzhongq
 * @time 2018年6月18日 下午7:36:50
 */
@Data
@Table(name = "sys_role")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String roleId;
	
	private String roleName;
	
	private String roleSign;
	
	private String remark;

}
